package chrome.tabgroups

external interface UpdateProperties {

	/** Whether the group should be collapsed. */
	var collapsed: Boolean?

	/** The color of the group. */
	var color: Color?

	/** The title of the group. */
	var title: String?
}

fun UpdateProperties(
	/** Whether the group should be collapsed. */
	collapsed: Boolean? = null,
	/** The color of the group. */
	color: Color? = null,
	/** The title of the group. */
	title: String? = null,
): UpdateProperties =
	js("{}").unsafeCast<UpdateProperties>().apply {
		this.collapsed = collapsed
		this.color = color
		this.title = title
	}