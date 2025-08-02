package chrome.runtime

fun ConnectInfo(
	/** Will be passed into onConnect for processes that are listening for the connection event. */
	name: String? = null,
	/** Whether the TLS channel ID will be passed into onConnectExternal for processes that are listening for the connection event. */
	includeTlsChannelId: Boolean? = null,
): ConnectInfo =
	js("{}").unsafeCast<ConnectInfo>().apply {
		this.name = name
		this.includeTlsChannelId = includeTlsChannelId
	}