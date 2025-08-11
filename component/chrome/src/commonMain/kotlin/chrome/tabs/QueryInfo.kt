package chrome.tabs

external interface QueryInfo {

	/** The tab loading status. */
	var status: TabStatus?

	/** Whether the tabs are in the last focused window. */
	var lastFocusedWindow: Boolean?

	/** The ID of the parent window, or {@link windows.WINDOW_ID_CURRENT} for the current window. */
	var windowId: Int?

	/** The type of window the tabs are in. */
	var windowType: WindowType?

	/** Whether the tabs are active in their windows. */
	var active: Boolean?

	/** The position of the tabs within their windows. */
	var index: Int?

	/** Match page titles against a pattern. This property is ignored if the extension does not have the `"tabs"` permission or host permissions for the page. */
	var title: String?

	/** Match tabs against one or more URL patterns. Fragment identifiers are not matched. This property is ignored if the extension does not have the `"tabs"` permission or host permissions for the page. */
	@Deprecated("Use extension with specified type", replaceWith = ReplaceWith("urlList"))
	var url: Any? /* string | string[] | undefined */

	/** Whether the tabs are in the current window. */
	var currentWindow: Boolean?

	/** Whether the tabs are highlighted. */
	var highlighted: Boolean?

	/**
	 * Whether the tabs are discarded. A discarded tab is one whose content has been unloaded from memory, but is still visible in the tab strip. Its content is reloaded the next time it is activated.
	 * @since Chrome 54
	 */
	var discarded: Boolean?

	/**
	 * Whether the tabs are frozen. A frozen tab cannot execute tasks, including event handlers or timers. It is visible in the tab strip and its content is loaded in memory. It is unfrozen on activation.
	 * @since Chrome 132
	 */
	var frozen: Boolean?

	/**
	 * Whether the tabs can be discarded automatically by the browser when resources are low.
	 * @since Chrome 54
	 */
	var autoDiscardable: Boolean?

	/** Whether the tabs are pinned. */
	var pinned: Boolean?

	/**
	 * Whether the tabs are audible.
	 * @since Chrome 45
	 */
	var audible: Boolean?

	/**
	 * Whether the tabs are muted.
	 * @since Chrome 45
	 */
	var muted: Boolean?

	/**
	 * The ID of the group that the tabs are in, or {@link chrome.tabGroups.TAB_GROUP_ID_NONE} for ungrouped tabs.
	 * @since Chrome 88
	 */
	var groupId: Int?
}
fun QueryInfo(
	/** The tab loading status. */
	status: TabStatus? = null,
	/** Whether the tabs are in the last focused window. */
	lastFocusedWindow: Boolean? = null,
	/** The ID of the parent window, or {@link windows.WINDOW_ID_CURRENT} for the current window. */
	windowId: Int? = null,
	/** The type of window the tabs are in. */
	windowType: WindowType? = null,
	/** Whether the tabs are active in their windows. */
	active: Boolean? = null,
	/** The position of the tabs within their windows. */
	index: Int? = null,
	/** Match page titles against a pattern. This property is ignored if the extension does not have the `"tabs"` permission or host permissions for the page. */
	title: String? = null,
	/** Match tabs against one or more URL patterns. Fragment identifiers are not matched. This property is ignored if the extension does not have the `"tabs"` permission or host permissions for the page. */
	url: List<String>,
	/** Whether the tabs are in the current window. */
	currentWindow: Boolean? = null,
	/** Whether the tabs are highlighted. */
	highlighted: Boolean? = null,
	/**
	 * Whether the tabs are discarded. A discarded tab is one whose content has been unloaded from memory, but is still visible in the tab strip. Its content is reloaded the next time it is activated.
	 * @since Chrome 54
	 */
	discarded: Boolean? = null,
	/**
	 * Whether the tabs are frozen. A frozen tab cannot execute tasks, including event handlers or timers. It is visible in the tab strip and its content is loaded in memory. It is unfrozen on activation.
	 * @since Chrome 132
	 */
	frozen: Boolean? = null,
	/**
	 * Whether the tabs can be discarded automatically by the browser when resources are low.
	 * @since Chrome 54
	 */
	autoDiscardable: Boolean? = null,
	/** Whether the tabs are pinned. */
	pinned: Boolean? = null,
	/**
	 * Whether the tabs are audible.
	 * @since Chrome 45
	 */
	audible: Boolean? = null,
	/**
	 * Whether the tabs are muted.
	 * @since Chrome 45
	 */
	muted: Boolean? = null,
	/**
	 * The ID of the group that the tabs are in, or {@link chrome.tabGroups.TAB_GROUP_ID_NONE} for ungrouped tabs.
	 * @since Chrome 88
	 */
	groupId: Int? = null,
): QueryInfo =
	js("{}").unsafeCast<QueryInfo>().apply {
		this.status = status
		this.lastFocusedWindow = lastFocusedWindow
		this.windowId = windowId
		this.windowType = windowType
		this.active = active
		this.index = index
		this.title = title
		this.url = url
		this.currentWindow = currentWindow
		this.highlighted = highlighted
		this.discarded = discarded
		this.frozen = frozen
		this.autoDiscardable = autoDiscardable
		this.pinned = pinned
		this.audible = audible
		this.muted = muted
		this.groupId = groupId
	}