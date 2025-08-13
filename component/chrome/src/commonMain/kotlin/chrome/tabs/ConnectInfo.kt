package chrome.tabs

external interface ConnectInfo {

	/** Is passed into onConnect for content scripts that are listening for the connection event. */
	var name: String?

	/** Open a port to a specific frame identified by `frameId` instead of all frames in the tab. */
	var frameId: Int?

	/**
	 * Open a port to a specific document identified by `documentId` instead of all frames in the tab.
	 * @since Chrome 106
	 */
	var documentId: String?
}

fun ConnectInfo(
	/** Is passed into onConnect for content scripts that are listening for the connection event. */
	name: String? = null,
	/** Open a port to a specific frame identified by `frameId` instead of all frames in the tab. */
	frameId: Int? = null,
	/**
	 * Open a port to a specific document identified by `documentId` instead of all frames in the tab.
	 * @since Chrome 106
	 */
	documentId: String? = null,
): ConnectInfo =
	js("{}").unsafeCast<ConnectInfo>().apply {
		this.name = name
		this.frameId = frameId
		this.documentId = documentId
	}