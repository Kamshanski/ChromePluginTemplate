package chrome.tabs

external interface HighlightInfo {

	/** One or more tab indices to highlight. */
	@Deprecated("Use extension with specified type", replaceWith = ReplaceWith("tabList"))
	var tabs: Any /* number | number[] */

	/** The window that contains the tabs. */
	var windowId: Int?
}

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