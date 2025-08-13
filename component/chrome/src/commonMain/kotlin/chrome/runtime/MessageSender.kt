package chrome.runtime

import chrome.extensiontypes.DocumentLifecycle
import chrome.tabs.Tab

/** An object containing information about the script context that sent a message or request */
external interface MessageSender {

	/** The ID of the extension that opened the connection, if any. */
	var id: String?

	/** The {@link tabs.Tab} which opened the connection, if any. This property will **only** be present when the connection was opened from a tab (including content scripts), and **only** if the receiver is an extension, not an app. */
	var tab: Tab?

	/**
	 * The name of the native application that opened the connection, if any.
	 * @since Chrome 74
	 */
	var nativeApplication: String?

	/** The frame that opened the connection. 0 for top-level frames, positive for child frames. This will only be set when tab is set. */
	var frameId: Int?

	/** The URL of the page or frame that opened the connection. If the sender is in an iframe, it will be iframe's URL not the URL of the page which hosts it. */
	var url: String?

	/** The TLS channel ID of the page or frame that opened the connection, if requested by the extension, and if available */
	var tlsChannelId: String?

	/**
	 * The origin of the page or frame that opened the connection. It can vary from the url property (e.g., about:blank) or can be opaque (e.g., sandboxed iframes). This is useful for identifying if the origin can be trusted if we can't immediately tell from the URL.
	 * @since Chrome 80
	 */
	var origin: String?

	/**
	 * The lifecycle the document that opened the connection is in at the time the port was created. Note that the lifecycle state of the document may have changed since port creation.
	 * @since Chrome 106
	 */
	var documentLifecycle: DocumentLifecycle?

	/**
	 * A UUID of the document that opened the connection.
	 * @since Chrome 106
	 */
	var documentId: String?
}