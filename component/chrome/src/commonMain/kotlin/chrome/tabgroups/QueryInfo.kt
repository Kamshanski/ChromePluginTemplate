@file:JsQualifier("chrome.tabGroups")

package chrome.tabgroups

external interface QueryInfo {

	/** Whether the groups are collapsed. */
	var collapsed: Boolean?

	/** The color of the groups. */
	var color: Color?

	/**
	 * Whether the group is shared.
	 * @since Chrome 137
	 */
	var shared: Boolean?

	/** Match group titles against a pattern. */
	var title: String?

	/** The ID of the parent window, or {@link windows.WINDOW_ID_CURRENT} for the current window. */
	var windowId: Int?
}