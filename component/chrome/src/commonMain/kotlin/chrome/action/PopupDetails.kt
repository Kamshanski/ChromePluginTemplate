package chrome.action

external interface PopupDetails {

	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	var tabId: Int?

	/** The html file to show in a popup. If set to the empty string (`''`), no popup is shown. */
	var popup: String
}

fun PopupDetails(
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
	/** The html file to show in a popup. If set to the empty string (`''`), no popup is shown. */
	popup: String,
): PopupDetails =
	js("{}").unsafeCast<PopupDetails>().apply {
		this.tabId = tabId
		this.popup = popup
	}