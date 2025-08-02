@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface MessageOptions {

	/** Whether the TLS channel ID will be passed into onMessageExternal for processes that are listening for the connection event. */
	var includeTlsChannelId: Boolean?
}