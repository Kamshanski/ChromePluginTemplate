package chrome.action

fun TabDetails(
	/** The ID of the tab to query state for. If no tab is specified, the non-tab-specific state is returned.  */
	tabId: Int?,
): TabDetails =
	js("{}").unsafeCast<TabDetails>().apply {
		this.tabId = tabId
	}