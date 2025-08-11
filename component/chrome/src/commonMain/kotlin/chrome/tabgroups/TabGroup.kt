package chrome.tabgroups

external interface TabGroup {

	/** Whether the group is collapsed. A collapsed group is one whose tabs are hidden. */
	var collapsed: Boolean

	/** The group's color. */
	var color: Color

	/** The ID of the group. Group IDs are unique within a browser session. */
	var id: Double

	/**
	 * Whether the group is shared.
	 * @since Chrome 137
	 */
	var shared: Boolean

	/** The title of the group. */
	var title: String?

	/** The ID of the window that contains the group. */
	var windowId: Int
}