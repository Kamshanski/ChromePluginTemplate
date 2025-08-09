@file:JsQualifier("chrome.tabGroups")

package chrome.tabgroups

external interface UpdateProperties {

	/** Whether the group should be collapsed. */
	var collapsed: Boolean?

	/** The color of the group. */
	var color: Color?

	/** The title of the group. */
	var title: String?
}