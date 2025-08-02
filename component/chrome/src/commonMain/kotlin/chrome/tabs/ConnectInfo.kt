@file:JsQualifier("chrome.tabs")

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