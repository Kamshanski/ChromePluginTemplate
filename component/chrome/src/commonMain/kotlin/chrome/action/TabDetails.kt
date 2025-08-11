package chrome.action

external interface TabDetails {

	/** The ID of the tab to query state for. If no tab is specified, the non-tab-specific state is returned.  */
	var tabId: Int?
}

fun TabDetails(
	/** The ID of the tab to query state for. If no tab is specified, the non-tab-specific state is returned.  */
	tabId: Int?,
): TabDetails =
	js("{}").unsafeCast<TabDetails>().apply {
		this.tabId = tabId
	}