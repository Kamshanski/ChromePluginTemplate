package chrome.tabgroups

external interface MoveProperties {

	/** The position to move the group to. Use `-1` to place the group at the end of the window. */
	var index: Int

	/** The window to move the group to. Defaults to the window the group is currently in. Note that groups can only be moved to and from windows with {@link windows.windowTypeEnum windows.windowType} type `"normal"`. */
	var windowId: Int?
}

fun MoveProperties(
	/** The position to move the group to. Use `-1` to place the group at the end of the window. */
	index: Int,
	/** The window to move the group to. Defaults to the window the group is currently in. Note that groups can only be moved to and from windows with {@link windows.windowTypeEnum windows.windowType} type `"normal"`. */
	windowId: Int? = null,
): MoveProperties =
	js("{}").unsafeCast<MoveProperties>().apply {
		this.index = index
		this.windowId = windowId
	}