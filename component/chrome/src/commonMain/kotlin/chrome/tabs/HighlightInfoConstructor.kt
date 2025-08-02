package chrome.tabs

fun HighlightInfo(
	/** One or more tab indices to highlight. */
	tabs: List<Int>,
	/** The window that contains the tabs. */
	windowId: Int? = null,
): HighlightInfo =
	js("{}").unsafeCast<HighlightInfo>().apply {
		this.tabs = tabs
		this.windowId = windowId
	}