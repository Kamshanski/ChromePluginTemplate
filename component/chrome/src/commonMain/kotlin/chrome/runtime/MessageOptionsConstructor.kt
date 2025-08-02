package chrome.runtime

fun MessageOptions(
	/** Whether the TLS channel ID will be passed into onMessageExternal for processes that are listening for the connection event. */
	includeTlsChannelId: Boolean? = null,
): MessageOptions =
	js("{}").unsafeCast<MessageOptions>().apply {
		this.includeTlsChannelId = includeTlsChannelId
	}