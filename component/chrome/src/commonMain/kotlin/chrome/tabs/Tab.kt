package chrome.tabs

external interface Tab {

	/** The tab's loading status. */
	var status: TabStatus?

	/** The zero-based index of the tab within its window. */
	var index: Int

	/** The ID of the tab that opened this tab, if any. This property is only present if the opener tab still exists. */
	var openerTabId: Int?

	/** The title of the tab. This property is only present if the extension has the `"tabs"` permission or has host permissions for the page. */
	var title: String?

	/** The last committed URL of the main frame of the tab. This property is only present if the extension has the `"tabs"` permission or has host permissions for the page. May be an empty string if the tab has not yet committed. See also {@link Tab.pendingUrl}. */
	var url: String?

	/**
	 * The URL the tab is navigating to, before it has committed. This property is only present if the extension has the `"tabs"` permission or has host permissions for the page and there is a pending navigation.
	 * @since Chrome 79
	 */
	var pendingUrl: String?

	/** Whether the tab is pinned. */
	var pinned: Boolean

	/** Whether the tab is highlighted. */
	var highlighted: Boolean

	/** The ID of the window that contains the tab. */
	var windowId: Int

	/** Whether the tab is active in its window. Does not necessarily mean the window is focused. */
	var active: Boolean

	/** The URL of the tab's favicon. This property is only present if the extension has the `tabs` permission or has host permissions for the page. It may also be an empty string if the tab is loading. */
	var favIconUrl: String?

	/**
	 * Whether the tab is frozen. A frozen tab cannot execute tasks, including event handlers or timers. It is visible in the tab strip and its content is loaded in memory. It is unfrozen on activation.
	 * @since Chrome 132
	 */
	var frozen: Boolean

	/** The ID of the tab. Tab IDs are unique within a browser session. Under some circumstances a tab may not be assigned an ID; for example, when querying foreign tabs using the {@link sessions} API, in which case a session ID may be present. Tab ID can also be set to `chrome.tabs.TAB_ID_NONE` for apps and devtools windows. */
	var id: Int?

	/** Whether the tab is in an incognito window. */
	var incognito: Boolean

	/**
	 * Whether the tab is selected.
	 * @deprecated since Chrome 33. Please use {@link Tab.highlighted}.
	 */
	var selected: Boolean

	/**
	 * Whether the tab has produced sound over the past couple of seconds (but it might not be heard if also muted). Equivalent to whether the 'speaker audio' indicator is showing.
	 * @since Chrome 45
	 */
	var audible: Boolean?

	/**
	 * Whether the tab is discarded. A discarded tab is one whose content has been unloaded from memory, but is still visible in the tab strip. Its content is reloaded the next time it is activated.
	 * @since Chrome 54
	 */
	var discarded: Boolean

	/**
	 * Whether the tab can be discarded automatically by the browser when resources are low.
	 * @since Chrome 54
	 */
	var autoDiscardable: Boolean

	/**
	 * The tab's muted state and the reason for the last state change.
	 * @since Chrome 46
	 */
	var mutedInfo: MutedInfo?

	/** The width of the tab in pixels. */
	var width: Int?

	/** The height of the tab in pixels. */
	var height: Int?

	/** The session ID used to uniquely identify a tab obtained from the {@link sessions} API. */
	var sessionId: String?

	/**
	 * The ID of the group that the tab belongs to.
	 * @since Chrome 88
	 */
	var groupId: Int

	/**
	 * The last time the tab became active in its window as the number of milliseconds since epoch.
	 * @since Chrome 121
	 */
	var lastAccessed: Double?
}