package chrome.extension

external interface FetchProperties {

	/**
	 * Optional.
	 * Chrome 54+
	 * Find a view according to a tab id. If this field is omitted, returns all views.
	 */
	var tabId: Int?

	/** Optional. The window to restrict the search to. If omitted, returns all views.  */
	var windowId: Int?

	/** Optional. The type of view to get. If omitted, returns all views (including background pages and tabs). Valid values: 'tab', 'notification', 'popup'.  */
	var type: String?
}

fun FetchProperties(
	/**
	 * Optional.
	 * Chrome 54+
	 * Find a view according to a tab id. If this field is omitted, returns all views.
	 */
	tabId: Int? = null,
	/** Optional. The window to restrict the search to. If omitted, returns all views.  */
	windowId: Int? = null,
	/** Optional. The type of view to get. If omitted, returns all views (including background pages and tabs). Valid values: 'tab', 'notification', 'popup'.  */
	type: String? = null,
): FetchProperties =
	js("{}").unsafeCast<FetchProperties>().apply {
		this.tabId = tabId
		this.windowId = windowId
		this.type = type
	}