package chrome.action

external interface BadgeTextDetails {

	/** Any number of characters can be passed, but only about four can fit in the space. If an empty string (`''`) is passed, the badge text is cleared. If `tabId` is specified and `text` is null, the text for the specified tab is cleared and defaults to the global badge text. */
	var text: String?

	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	var tabId: Int?
}

fun BadgeTextDetails(
	/** Any number of characters can be passed, but only about four can fit in the space. If an empty string (`''`) is passed, the badge text is cleared. If `tabId` is specified and `text` is null, the text for the specified tab is cleared and defaults to the global badge text. */
	text: String? = null,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
): BadgeTextDetails =
	js("{}").unsafeCast<BadgeTextDetails>().apply {
		this.text = text
		this.tabId = tabId
	}