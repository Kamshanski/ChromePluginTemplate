package chrome.action

fun TitleDetails(
	/** The string the action should display when moused over. */
	title: String,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	tabId: Int? = null,
): TitleDetails =
	js("{}").unsafeCast<TitleDetails>().apply {
		this.title = title
		this.tabId = tabId
	}