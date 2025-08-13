package chrome.runtime

import chrome.events.Event

/** An object which allows two way communication with other pages. */
external interface Port {

	/** Send a message to the other end of the port. If the port is disconnected, an error is thrown. */
	var postMessage: (message: Any?) -> Unit

	/** Immediately disconnect the port. Calling `disconnect()` on an already-disconnected port has no effect. When a port is disconnected, no new events will be dispatched to this port. */
	var disconnect: () -> Unit

	/** This property will **only** be present on ports passed to {@link runtime.onConnect onConnect} / {@link runtime.onConnectExternal onConnectExternal} / {@link runtime.onConnectExternal onConnectNative} listeners. */
	var sender: MessageSender?

	/** Fired when the port is disconnected from the other end(s). {@link runtime.lastError} may be set if the port was disconnected by an error. If the port is closed via {@link Port.disconnect disconnect}, then this event is _only_ fired on the other end. This event is fired at most once (see also Port lifetime). */
	var onDisconnect: Event<(port: Port) -> Unit>

	/** This event is fired when {@link Port.postMessage postMessage} is called by the other end of the port. */
	var onMessage: Event<(message: Any?, port: Port) -> Unit>

	/** The name of the port, as specified in the call to {@link runtime.connect}. */
	var name: String
}