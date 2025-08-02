package chrome.tabs

fun MessageSendOptions(
	/** Send a message to a specific frame identified by `frameId` instead of all frames in the tab. */
	frameId: Int? = null,
	/**
	 * Send a message to a specific document identified by `documentId` instead of all frames in the tab.
	 * @since Chrome 106
	 */
	documentId: Int? = null,
): MessageSendOptions =
	js("{}").unsafeCast<MessageSendOptions>().apply {
		this.frameId = frameId
		this.documentId = documentId
	}