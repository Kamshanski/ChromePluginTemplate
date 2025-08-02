@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface ConnectInfo {

	/** Will be passed into onConnect for processes that are listening for the connection event. */
	var name: String?

	/** Whether the TLS channel ID will be passed into onConnectExternal for processes that are listening for the connection event. */
	var includeTlsChannelId: Boolean?
}