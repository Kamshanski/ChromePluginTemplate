package chrome.tabs

external interface GroupOptions {

	/** Configurations for creating a group. Cannot be used if groupId is already specified. */
	var createProperties: GroupCreateProperties?

	/** The ID of the group to add the tabs to. If not specified, a new group will be created. */
	var groupId: Int?

	/** The tab ID or list of tab IDs to add to the specified group. */
	@Deprecated("Use extension with specified type", replaceWith = ReplaceWith("tabIdList"))
	var tabIds: Any? /* number | [number, ...number[]] | undefined */
}

fun GroupOptions(
	/** Configurations for creating a group. Cannot be used if groupId is already specified. */
	createProperties: GroupCreateProperties? = null,
	/** The ID of the group to add the tabs to. If not specified, a new group will be created. */
	groupId: Int? = null,
	/** The tab ID or list of tab IDs to add to the specified group. */
	tabIds: List<Int>,
): GroupOptions =
	js("{}").unsafeCast<GroupOptions>().apply {
		this.createProperties = createProperties
		this.groupId = groupId
		this.tabIds = tabIds
	}