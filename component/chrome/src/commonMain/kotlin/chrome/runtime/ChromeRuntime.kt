@file:JsQualifier("chrome")

package chrome.runtime

import chrome.DirectoryEntry
import chrome.events.Event
import org.w3c.dom.Window
import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

/**
 * Use the `chrome.runtime` API to retrieve the service worker, return details about the manifest, and listen for and respond to events in the extension lifecycle. You can also use this API to convert the relative path of URLs to fully-qualified URLs.
 */
@Suppress("unused")
@JsName("runtime")
external object ChromeRuntime {

	/** Populated with an error message if calling an API function fails; otherwise undefined. This is only defined within the scope of that function's callback. If an error is produced, but `runtime.lastError` is not accessed within the callback, a message is logged to the console listing the API function that produced the error. API functions that return promises do not set this property. */
	val lastError: LastError?

	/** The ID of the extension/app. */
	val id: String

	/**
	 * Attempts to connect listeners within an extension (such as the background page), or other extensions/apps. This is useful for content scripts connecting to their extension processes, inter-app/extension communication, and web messaging. Note that this does not connect to any listeners in a content script. Extensions may connect to content scripts embedded in tabs via {@link tabs.connect}.
	 *
	 * @param extensionId The ID of the extension to connect to. If omitted, a connection will be attempted with your own extension. Required if sending messages from a web page for web messaging.
	 * @returns Port through which messages can be sent and received. The port's {@link Port onDisconnect} event is fired if the extension does not exist.
	 */
	fun connect(extensionId: String?, connectInfo: ConnectInfo = definedExternally): Port
	fun connect(connectInfo: ConnectInfo = definedExternally): Port

	/**
	 * Connects to a native application in the host machine. This method requires the `"nativeMessaging"` permission. See Native Messaging for more information.
	 * @param application The name of the registered application to connect to.
	 */
	fun connectNative(application: String): Port

	/**
	 * Retrieves the JavaScript 'window' object for the background page running inside the current extension/app. If the background page is an event page, the system will ensure it is loaded before calling the callback. If there is no background page, an error is set.
	 *
	 * Foreground only
	 *
	 * Can return its result via Promise since Chrome 99.
	 * @deprecated since Chrome 133. Background pages do not exist in MV3 extensions.
	 */
	fun getBackgroundPage(): Promise<Window?>
	fun getBackgroundPage(callback: (backgroundPage: Window? /* use undefined for default */) -> Unit)

	/**
	 * Fetches information about active contexts associated with this extension
	 * @param filter A filter to find matching contexts. A context matches if it matches all specified fields in the filter. Any unspecified field in the filter matches all contexts.
	 * @since Chrome 116 MV3.
	 */
	fun getContexts(filter: ContextFilter): Promise<JsReadonlyArray<ExtensionContext>>
	fun getContexts(filter: ContextFilter, callback: (contexts: JsReadonlyArray<ExtensionContext>) -> Unit)

	/**
	 * Returns details about the app or extension from the manifest. The object returned is a serialization of the full manifest file.
	 * @return The manifest details.
	 */
	fun getManifest(): Manifest

	/**
	 * Returns a DirectoryEntry for the package directory.
	 *
	 * Foreground only
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 122.
	 */
	fun getPackageDirectoryEntry(): Promise<DirectoryEntry>
	fun getPackageDirectoryEntry(callback: (directoryEntry: DirectoryEntry) -> Unit)

	/**
	 * Returns information about the current platform.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 99.
	 */
	fun getPlatformInfo(): Promise<PlatformInfo>
	fun getPlatformInfo(callback: (platformInfo: PlatformInfo) -> Unit)

	/**
	 * Converts a relative path within an app/extension install directory to a fully-qualified URL.
	 * @param path A path to a resource within an app/extension expressed relative to its install directory.
	 * @returns The fully-qualified URL to the resource.
	 */
	fun getURL(path: String): String

	/** Reloads the app or extension. This method is not supported in kiosk mode. For kiosk mode, use {@link chrome.runtime.restart()} method. */
	fun reload()

	/**
	 * Requests an immediate update check be done for this app/extension.
	 *
	 * **Important**: Most extensions/apps should **not** use this method, since Chrome already does automatic checks every few hours, and you can listen for the {@link runtime.onUpdateAvailable} event without needing to call requestUpdateCheck.
	 *
	 * This method is only appropriate to call in very limited circumstances, such as if your extension talks to a backend service, and the backend service has determined that the client extension version is very far out of date and you'd like to prompt a user to update. Most other uses of requestUpdateCheck, such as calling it unconditionally based on a repeating timer, probably only serve to waste client, network, and server resources.
	 *
	 * Note: When called with a callback, instead of returning an object this function will return the two properties as separate arguments passed to the callback.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 109.
	 */
	fun requestUpdateCheck(): Promise<RequestUpdateCheckResult>
	fun requestUpdateCheck(callback: (status: String /* `${RequestUpdateCheckStatus}` */, details: UpdateCheckDetails? /* use undefined for default */) -> Unit)

	/** Restart the ChromeOS device when the app runs in kiosk mode. Otherwise, it's no-op. */
	fun restart()

	/**
	 * Restart the ChromeOS device when the app runs in kiosk mode after the given seconds. If called again before the time ends, the reboot will be delayed. If called with a value of `-1`, the reboot will be cancelled. It's a no-op in non-kiosk mode. It's only allowed to be called repeatedly by the first extension to invoke this API.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 99.
	 * @since Chrome 53
	 */
	fun restartAfterDelay(seconds: Double): Promise<Unit>
	fun restartAfterDelay(seconds: Double, callback: () -> Unit)

	/**
	 * Sends a single message to event listeners within your extension or a different extension/app. Similar to {@link runtime.connect} but only sends a single message, with an optional response. If sending to your extension, the {@link runtime.onMessage} event will be fired in every frame of your extension (except for the sender's frame), or {@link runtime.onMessageExternal}, if a different extension. Note that extensions cannot send messages to content scripts using this method. To send messages to content scripts, use {@link tabs.sendMessage}.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 99.
	 * @param extensionId The ID of the extension to send the message to. If omitted, the message will be sent to your own extension/app. Required if sending messages from a web page for web messaging.
	 * @param message The message to send. This message should be a JSON-ifiable object.
	 */
	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(extensionId: String?, message: M, options: MessageOptions = definedExternally): Promise<R>
	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(extensionId: String?, message: M, callback: (response: R) -> Unit)
	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(extensionId: String?, message: M, options: MessageOptions?, callback: (response: R) -> Unit)
	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(message: M, options: MessageOptions = definedExternally): Promise<R>
	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(message: M, callback: (response: R) -> Unit)
	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(message: M, options: MessageOptions?, callback: (response: R) -> Unit)

	/**
	 * Send a single message to a native application. This method requires the `"nativeMessaging"` permission
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 99.
	 * @param application The name of the native messaging host.
	 * @param message The message that will be passed to the native messaging host.
	 */
	fun sendNativeMessage(application: String, message: Any): Promise<Any?>
	fun sendNativeMessage(application: String, message: Any, callback: (response: Any?) -> Unit)

	/**
	 * Sets the URL to be visited upon uninstallation. This may be used to clean up server-side data, do analytics, and implement surveys. Maximum 1023 characters.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 99.
	 * @param url URL to be opened after the extension is uninstalled. This URL must have an http: or https: scheme. Set an empty string to not open a new tab upon uninstallation.
	 */
	fun setUninstallURL(url: String): Promise<Unit>
	fun setUninstallURL(url: String, callback: () -> Unit)

	/**
	 * Open your Extension's options page, if possible.
	 *
	 * The precise behavior may depend on your manifest's options_ui or options_page key, or what Chrome happens to support at the time. For example, the page may be opened in a new tab, within chrome://extensions, within an App, or it may just focus an open options page. It will never cause the caller page to reload.
	 *
	 * If your Extension does not declare an options page, or Chrome failed to create one for some other reason, the callback will set {@link runtime.lastError lastError} .
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 99
	 */
	fun openOptionsPage(): Promise<Unit>
	fun openOptionsPage(callback: () -> Unit)

	/** Fired when a connection is made from either an extension process or a content script (by {@link runtime.connect}). */
	val onConnect: Event<(port: Port) -> Unit>

	/** Fired when a connection is made from another extension (by {@link runtime.connect}), or from an externally connectable web site. */
	val onConnectExternal: Event<(port: Port) -> Unit>

	/**
	 * Fired when a connection is made from a native application. This event requires the `"nativeMessaging"` permission. It is only supported on Chrome OS.
	 * @since Chrome 76
	 */
	val onConnectNative: Event<(port: Port) -> Unit>

	/** Sent to the event page just before it is unloaded. This gives the extension opportunity to do some clean up. Note that since the page is unloading, any asynchronous operations started while handling this event are not guaranteed to complete. If more activity for the event page occurs before it gets unloaded the onSuspendCanceled event will be sent and the page won't be unloaded. */
	val onSuspend: Event<() -> Unit>

	/** Fired when a profile that has this extension installed first starts up. This event is not fired when an incognito profile is started, even if this extension is operating in 'split' incognito mode. */
	val onStartup: Event<() -> Unit>

	/** Fired when the extension is first installed, when the extension is updated to a new version, and when Chrome is updated to a new version. */
	val onInstalled: Event<(details: InstalledDetails) -> Unit>

	/** Sent after onSuspend to indicate that the app won't be unloaded after all. */
	val onSuspendCanceled: Event<() -> Unit>

	/** Fired when a message is sent from either an extension process (by {@link runtime.sendMessage}) or a content script (by {@link tabs.sendMessage}). */
	val onMessage: Event<(message: Any?, sender: MessageSender, sendResponse: (response: Any? /* use undefined for default */) -> Unit) -> Unit>

	/** Fired when a message is sent from another extension (by {@link runtime.sendMessage}). Cannot be used in a content script. */
	val onMessageExternal: Event<(message: Any?, sender: MessageSender, sendResponse: (response: Any? /* use undefined for default */) -> Unit) -> Unit>

	/** Fired when an app or the device that it runs on needs to be restarted. The app should close all its windows at its earliest convenient time to let the restart to happen. If the app does nothing, a restart will be enforced after a 24-hour grace period has passed. Currently, this event is only fired for Chrome OS kiosk apps. */
	val onRestartRequired: Event<(reason: String /* `${OnRestartRequiredReason}` */) -> Unit>

	/** Fired when an update is available, but isn't installed immediately because the app is currently running. If you do nothing, the update will be installed the next time the background page gets unloaded, if you want it to be installed sooner you can explicitly call chrome.runtime.reload(). If your extension is using a persistent background page, the background page of course never gets unloaded, so unless you call chrome.runtime.reload() manually in response to this event the update will not get installed until the next time Chrome itself restarts. If no handlers are listening for this event, and your extension has a persistent background page, it behaves as if chrome.runtime.reload() is called in response to this event. */
	val onUpdateAvailable: Event<(details: UpdateAvailableDetails) -> Unit>

	/**
	 * Fired when a Chrome update is available, but isn't installed immediately because a browser restart is required.
	 * @deprecated Please use {@link runtime.onRestartRequired}.
	 */
	val onBrowserUpdateAvailable: Event<() -> Unit>

	/**
	 * Fired when a connection is made from a user script from this extension.
	 * @since chrome 115 MV3
	 */
	val onUserScriptConnect: Event<(port: Port) -> Unit>

	/**
	 * Fired when a message is sent from a user script associated with the same extension.
	 * @since chrome 115, MV3
	 */
	val onUserScriptMessage: Event<(message: Any?, sender: MessageSender, sendResponse: (response: Any? /* use undefined for default */) -> Unit) -> Unit>
}