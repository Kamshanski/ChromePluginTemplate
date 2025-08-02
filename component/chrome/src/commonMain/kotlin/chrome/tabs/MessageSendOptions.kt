@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface MessageSendOptions {

	/** Send a message to a specific frame identified by `frameId` instead of all frames in the tab. */
	var frameId: Int?

	/**
	 * Send a message to a specific document identified by `documentId` instead of all frames in the tab.
	 * @since Chrome 106
	 */
	var documentId: Int?
}