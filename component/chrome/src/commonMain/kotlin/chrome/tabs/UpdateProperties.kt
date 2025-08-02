@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface UpdateProperties {

	/** Whether the tab should be pinned. */
	var pinned: Boolean?

	/** The ID of the tab that opened this tab. If specified, the opener tab must be in the same window as this tab. */
	var openerTabId: Int?

	/** A URL to navigate the tab to. JavaScript URLs are not supported; use {@link scripting.executeScript} instead. */
	var url: String?

	/** Adds or removes the tab from the current selection. */
	var highlighted: Boolean?

	/** Whether the tab should be active. Does not affect whether the window is focused (see {@link windows.update}).*/
	var active: Boolean?

	/**
	 * Whether the tab should be selected.
	 * @deprecated since Chrome 33. Please use {@link highlighted}.
	 */
	var selected: Boolean?

	/**
	 * Whether the tab should be muted.
	 * @since Chrome 45
	 */
	var muted: Boolean?

	/**
	 * Whether the tab should be discarded automatically by the browser when resources are low.
	 * @since Chrome 54
	 */
	var autoDiscardable: Boolean?
}