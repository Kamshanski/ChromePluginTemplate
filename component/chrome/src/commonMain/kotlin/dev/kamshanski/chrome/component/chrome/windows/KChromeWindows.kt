package dev.kamshanski.chrome.component.chrome.windows

import chrome.events.Event
import chrome.windows.ChromeWindows
import chrome.windows.CreateData
import chrome.windows.QueryOptions
import chrome.windows.UpdateInfo
import chrome.windows.Window
import chrome.windows.WindowsEvent
import kotlinx.coroutines.await
import kotlin.js.collections.JsReadonlyArray

/**
 * Use the `chrome.windows` API to interact with browser windows. You can use this API to create, modify, and rearrange windows in the browser.
 *
 * Permissions: The chrome.windows API can be used without declaring any permission. However, the "tabs" permission is required in order to populate the url, title, and favIconUrl properties of Tab objects.
 */
@Suppress("unused")
object KChromeWindows {

	/** The windowId value that represents the current window. */
	val WINDOW_ID_CURRENT: Int /* -2 */ by ChromeWindows::WINDOW_ID_CURRENT

	/** The windowId value that represents the absence of a Chrome browser window */
	val WINDOW_ID_NONE: Int /* -1 */ by ChromeWindows::WINDOW_ID_NONE

	/**
	 * Gets details about a window.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun get(windowId: Int): Window = ChromeWindows.get(windowId).await()
	suspend fun get(windowId: Int, queryOptions: QueryOptions): Window = ChromeWindows.get(windowId, queryOptions).await()

	/**
	 * Gets the current window.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun getCurrent(): Window = ChromeWindows.getCurrent().await()
	suspend fun getCurrent(queryOptions: QueryOptions): Window = ChromeWindows.getCurrent(queryOptions).await()

	/**
	 * Creates (opens) a new browser window with any optional sizing, position, or default URL provided.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun create(): Window? = ChromeWindows.create().await()
	suspend fun create(createData: CreateData): Window? = ChromeWindows.create(createData).await()

	/**
	 * Gets all windows.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun getAll(): JsReadonlyArray<Window> = ChromeWindows.getAll().await()
	suspend fun getAll(queryOptions: QueryOptions): JsReadonlyArray<Window> = ChromeWindows.getAll(queryOptions).await()

	/**
	 * Updates the properties of a window. Specify only the properties that to be changed; unspecified properties are unchanged.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun update(windowId: Int, updateInfo: UpdateInfo): Window = ChromeWindows.update(windowId, updateInfo).await()

	/**
	 * Removes (closes) a window and all the tabs inside it.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun remove(windowId: Int) = ChromeWindows.remove(windowId).await()

	/**
	 * Gets the window that was most recently focused — typically the window 'on top'.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun getLastFocused(): Window  = ChromeWindows.getLastFocused().await()
	suspend fun getLastFocused(queryOptions: QueryOptions): Window  = ChromeWindows.getLastFocused(queryOptions).await()

	/** Fired when a window is removed (closed). */
	val onRemoved: WindowsEvent<(windowId: Int) -> Unit> by ChromeWindows::onRemoved

	/** Fired when a window is created. */
	val onCreated: WindowsEvent<(window: Window) -> Unit> by ChromeWindows::onCreated

	/** Fired when the currently focused window changes. Returns `chrome.windows.WINDOW_ID_NONE` if all Chrome windows have lost focus. **Note:** On some Linux window managers, `WINDOW_ID_NONE` is always sent immediately preceding a switch from one Chrome window to another. */
	val onFocusChanged: WindowsEvent<(windowId: Int) -> Unit> by ChromeWindows::onFocusChanged

	/**
	 * Fired when a window has been resized; this event is only dispatched when the new bounds are committed, and not for in-progress changes.
	 * @since Chrome 86
	 */
	val onBoundsChanged: Event<(window: Window) -> Unit> by ChromeWindows::onBoundsChanged
}