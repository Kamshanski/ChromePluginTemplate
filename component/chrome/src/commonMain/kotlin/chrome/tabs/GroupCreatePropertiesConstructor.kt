package chrome.tabs

fun GroupCreateProperties(
	/** The window of the new group. Defaults to the current window. */
	windowId: Int? = null,
): GroupCreateProperties =
	js("{}").unsafeCast<GroupCreateProperties>().apply {
		this.windowId = windowId
	}