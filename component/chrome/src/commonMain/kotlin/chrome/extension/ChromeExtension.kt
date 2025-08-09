@file:JsQualifier("chrome")

package chrome.extension

import org.w3c.dom.Window
import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

/**
 * The `chrome.extension` API has utilities that can be used by any extension page. It includes support for exchanging messages between an extension and its content scripts or between extensions, as described in detail in Message Passing.
 */
@Suppress("unused")
@JsName("extension")
external object ChromeExtension {

	/**
	 * @since Chrome 7
	 * True for content scripts running inside incognito tabs, and for extension pages running inside an incognito process. The latter only applies to extensions with 'split' incognito_behavior.
	 */
	var inIncognitoContext: Boolean

	/** Set for the lifetime of a callback if an ansychronous extension api has resulted in an error. If no error has occurred lastError will be undefined. */
	var lastError: LastError

	/** Returns the JavaScript 'window' object for the background page running inside the current extension. Returns null if the extension has no background page. */
	fun getBackgroundPage(): Window?

	/**
	 * Converts a relative path within an extension install directory to a fully-qualified URL.
	 * @param path A path to a resource within an extension expressed relative to its install directory.
	 */
	fun getURL(path: String): String

	/**
	 * Sets the value of the ap CGI parameter used in the extension's update URL. This value is ignored for extensions that are hosted in the Chrome Extension Gallery.
	 * @since Chrome 9
	 */
	fun setUpdateUrlData(data: String)

	/** Returns an array of the JavaScript 'window' objects for each of the pages running inside the current extension. */
	fun getViews(fetchProperties: FetchProperties = definedExternally): JsReadonlyArray<Window>

	/**
	 * Retrieves the state of the extension's access to the 'file://' scheme (as determined by the user-controlled 'Allow access to File URLs' checkbox.
	 * @since Chrome 12
	 * @return The `isAllowedFileSchemeAccess` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	fun isAllowedFileSchemeAccess(): Promise<Boolean>

	/**
	 * Retrieves the state of the extension's access to the 'file://' scheme (as determined by the user-controlled 'Allow access to File URLs' checkbox.
	 * @since Chrome 12
	 * Parameter isAllowedAccess: True if the extension can access the 'file://' scheme, false otherwise.
	 */
	fun isAllowedFileSchemeAccess(callback: (isAllowedAccess: Boolean) -> Unit)

	/**
	 * Retrieves the state of the extension's access to Incognito-mode (as determined by the user-controlled 'Allowed in Incognito' checkbox.
	 * @since Chrome 12
	 * @return The `isAllowedIncognitoAccess` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	fun isAllowedIncognitoAccess(): Promise<Boolean>

	/**
	 * Retrieves the state of the extension's access to Incognito-mode (as determined by the user-controlled 'Allowed in Incognito' checkbox.
	 * @since Chrome 12
	 * Parameter isAllowedAccess: True if the extension has access to Incognito mode, false otherwise.
	 */
	fun isAllowedIncognitoAccess(callback: (isAllowedAccess: Boolean) -> Unit)

	/**
	 * Sends a single request to other listeners within the extension. Similar to runtime.connect, but only sends a single request with an optional response. The extension.onRequest event is fired in each page of the extension.
	 * @deprecated Deprecated since Chrome 33. Please use runtime.sendMessage.
	 * @param extensionId The extension ID of the extension you want to connect to. If omitted, default is your own extension.
	 * @param responseCallback If you specify the responseCallback parameter, it should be a function that looks like this:
	 * function(any response) {...};
	 * Parameter response: The JSON response object sent by the handler of the request. If an error occurs while connecting to the extension, the callback will be called with no arguments and runtime.lastError will be set to the error message.
	 */
	@Deprecated("Deprecated since Chrome 33. Please use runtime.sendMessage.")
	fun <
		Request /* default is Any? */,
		Response /* default is Any? */,
	> sendRequest(
		extensionId: String,
		request: Request,
		responseCallback: (response: Response) -> Unit = definedExternally
	)

	/**
	 * Sends a single request to other listeners within the extension. Similar to runtime.connect, but only sends a single request with an optional response. The extension.onRequest event is fired in each page of the extension.
	 * @deprecated Deprecated since Chrome 33. Please use runtime.sendMessage.
	 * @param responseCallback If you specify the responseCallback parameter, it should be a function that looks like this:
	 * function(any response) {...};
	 * Parameter response: The JSON response object sent by the handler of the request. If an error occurs while connecting to the extension, the callback will be called with no arguments and runtime.lastError will be set to the error message.
	 */
	@Deprecated("Deprecated since Chrome 33. Please use runtime.sendMessage.")
	fun <
		Request /* default is Any? */,
		Response /* default is Any? */
	> sendRequest(
		request: Request,
		responseCallback: (response: Response) -> Unit = definedExternally
	)

	/**
	 * Returns an array of the JavaScript 'window' objects for each of the tabs running inside the current extension. If windowId is specified, returns only the 'window' objects of tabs attached to the specified window.
	 * @deprecated Deprecated since Chrome 33. Please use extension.getViews {type: "tab"}.
	 */
	@Deprecated("Deprecated since Chrome 33. Please use extension.getViews {type: \"tab\"}.")
	fun getExtensionTabs(windowId: Int = definedExternally): JsReadonlyArray<Window>

	/**
	 * Fired when a request is sent from either an extension process or a content script.
	 * @deprecated Deprecated since Chrome 33. Please use runtime.onMessage.
	 */
	@Deprecated("Deprecated since Chrome 33. Please use runtime.onMessage.")
	var onRequest: OnRequestEvent

	/**
	 * Fired when a request is sent from another extension.
	 * @deprecated Deprecated since Chrome 33. Please use runtime.onMessageExternal.
	 */
	@Deprecated("Deprecated since Chrome 33. Please use runtime.onMessageExternal.")
	var onRequestExternal: OnRequestEvent
}