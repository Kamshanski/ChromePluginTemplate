package dev.kamshanski.chrome.component.chrome.extension

import chrome.extension.ChromeExtension
import chrome.extension.FetchProperties
import chrome.extension.LastError
import kotlinx.coroutines.await
import org.w3c.dom.Window
import kotlin.js.collections.JsReadonlyArray

/**
 * The `chrome.extension` API has utilities that can be used by any extension page. It includes support for exchanging messages between an extension and its content scripts or between extensions, as described in detail in Message Passing.
 */
@Suppress("unused")
object ChromeCoroutinesExtension {

	/**
	 * @since Chrome 7
	 * True for content scripts running inside incognito tabs, and for extension pages running inside an incognito process. The latter only applies to extensions with 'split' incognito_behavior.
	 */
	var inIncognitoContext: Boolean by ChromeExtension::inIncognitoContext

	/** Set for the lifetime of a callback if an ansychronous extension api has resulted in an error. If no error has occurred lastError will be undefined. */
	var lastError: LastError by ChromeExtension::lastError

	/** Returns the JavaScript 'window' object for the background page running inside the current extension. Returns null if the extension has no background page. */
	fun getBackgroundPage(): Window? = ChromeExtension.getBackgroundPage()

	/**
	 * Converts a relative path within an extension install directory to a fully-qualified URL.
	 * @param path A path to a resource within an extension expressed relative to its install directory.
	 */
	fun getURL(path: String): String = ChromeExtension.getURL(path)

	/**
	 * Sets the value of the ap CGI parameter used in the extension's update URL. This value is ignored for extensions that are hosted in the Chrome Extension Gallery.
	 * @since Chrome 9
	 */
	fun setUpdateUrlData(data: String) = ChromeExtension.setUpdateUrlData(data)

	/** Returns an array of the JavaScript 'window' objects for each of the pages running inside the current extension. */
	fun getViews(fetchProperties: FetchProperties): JsReadonlyArray<Window> = ChromeExtension.getViews(fetchProperties)
	fun getViews(): JsReadonlyArray<Window> = ChromeExtension.getViews()

	/**
	 * Retrieves the state of the extension's access to the 'file://' scheme (as determined by the user-controlled 'Allow access to File URLs' checkbox.
	 * @since Chrome 12
	 * @return The `isAllowedFileSchemeAccess` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun isAllowedFileSchemeAccess(): Boolean = ChromeExtension.isAllowedFileSchemeAccess().await()

	/**
	 * Retrieves the state of the extension's access to Incognito-mode (as determined by the user-controlled 'Allowed in Incognito' checkbox.
	 * @since Chrome 12
	 * @return The `isAllowedIncognitoAccess` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun isAllowedIncognitoAccess(): Boolean = ChromeExtension.isAllowedIncognitoAccess().await()
}