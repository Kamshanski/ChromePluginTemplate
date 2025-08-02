package chrome.tabs

fun MoveProperties(
	/** The position to move the window to. Use `-1` to place the tab at the end of the window. */
	index: Int,
	/** Defaults to the window the tab is currently in. */
	windowId: Int? = null,
): MoveProperties =
	js("{}").unsafeCast<MoveProperties>().apply {
		this.index = index
		this.windowId = windowId
	}