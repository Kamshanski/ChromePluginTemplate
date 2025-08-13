@file:JsQualifier("chrome")

package chrome.windows

import chrome.events.Event
import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

/**
 * Use the `chrome.windows` API to interact with browser windows. You can use this API to create, modify, and rearrange windows in the browser.
 *
 * Permissions: The chrome.windows API can be used without declaring any permission. However, the "tabs" permission is required in order to populate the url, title, and favIconUrl properties of Tab objects.
 */
@JsName("windows")
@Suppress("unused")
external object ChromeWindows {

	/** The windowId value that represents the current window. */
	val WINDOW_ID_CURRENT: Int /* -2 */

	/** The windowId value that represents the absence of a Chrome browser window */
	val WINDOW_ID_NONE: Int /* -1 */

	/**
	 * Gets details about a window.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun get(windowId: Int, queryOptions: QueryOptions = definedExternally): Promise<Window>
	fun get(windowId: Int, callback: (window: Window) -> Unit)
	fun get(windowId: Int, queryOptions: QueryOptions?, callback: (window: Window) -> Unit)

	/**
	 * Gets the current window.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun getCurrent(queryOptions: QueryOptions = definedExternally): Promise<Window>
	fun getCurrent(callback: (window: Window) -> Unit)
	fun getCurrent(queryOptions: QueryOptions?, callback: (window: Window) -> Unit)

	/**
	 * Creates (opens) a new browser window with any optional sizing, position, or default URL provided.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun create(createData: CreateData = definedExternally): Promise<Window?>
	fun create(callback: (window: Window? /* use undefined for default */) -> Unit)
	fun create(createData: CreateData?, callback: (window: Window? /* use undefined for default */) -> Unit)

	/**
	 * Gets all windows.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun getAll(queryOptions: QueryOptions = definedExternally): Promise<JsReadonlyArray<Window>>
	fun getAll(callback: (windows: JsReadonlyArray<Window>) -> Unit)
	fun getAll(queryOptions: QueryOptions?, callback: (windows: JsReadonlyArray<Window>) -> Unit)

	/**
	 * Updates the properties of a window. Specify only the properties that to be changed; unspecified properties are unchanged.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun update(windowId: Int, updateInfo: UpdateInfo): Promise<Window>
	fun update(windowId: Int, updateInfo: UpdateInfo, callback: (window: Window) -> Unit)

	/**
	 * Removes (closes) a window and all the tabs inside it.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun remove(windowId: Int): Promise<Unit>
	fun remove(windowId: Int, callback: () -> Unit)

	/**
	 * Gets the window that was most recently focused — typically the window 'on top'.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun getLastFocused(queryOptions: QueryOptions = definedExternally): Promise<Window>
	fun getLastFocused(callback: (window: Window) -> Unit)
	fun getLastFocused(queryOptions: QueryOptions?, callback: (window: Window) -> Unit)

	/** Fired when a window is removed (closed). */
	val onRemoved: WindowsEvent<(windowId: Int) -> Unit>

	/** Fired when a window is created. */
	val onCreated: WindowsEvent<(window: Window) -> Unit>

	/** Fired when the currently focused window changes. Returns `chrome.windows.WINDOW_ID_NONE` if all Chrome windows have lost focus. **Note:** On some Linux window managers, `WINDOW_ID_NONE` is always sent immediately preceding a switch from one Chrome window to another. */
	val onFocusChanged: WindowsEvent<(windowId: Int) -> Unit>

	/**
	 * Fired when a window has been resized; this event is only dispatched when the new bounds are committed, and not for in-progress changes.
	 * @since Chrome 86
	 */
	val onBoundsChanged: Event<(window: Window) -> Unit>
}