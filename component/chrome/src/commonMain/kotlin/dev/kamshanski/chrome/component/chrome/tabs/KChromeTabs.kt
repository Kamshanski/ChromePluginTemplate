package dev.kamshanski.chrome.component.chrome.tabs

import chrome.events.Event
import chrome.extensiontypes.ImageDetails
import chrome.extensiontypes.InjectDetails
import chrome.runtime.Port
import chrome.tabs.ChromeTabs
import chrome.tabs.ConnectInfo
import chrome.tabs.CreateProperties
import chrome.tabs.GroupOptions
import chrome.tabs.HighlightInfo
import chrome.tabs.MessageSendOptions
import chrome.tabs.MoveProperties
import chrome.tabs.OnActivatedInfo
import chrome.tabs.OnActiveChangedInfo
import chrome.tabs.OnAttachedInfo
import chrome.tabs.OnDetachedInfo
import chrome.tabs.OnHighlightChangedInfo
import chrome.tabs.OnHighlightedInfo
import chrome.tabs.OnMovedInfo
import chrome.tabs.OnRemovedInfo
import chrome.tabs.OnSelectionChangedInfo
import chrome.tabs.OnUpdatedInfo
import chrome.tabs.OnZoomChangeInfo
import chrome.tabs.QueryInfo
import chrome.tabs.ReloadProperties
import chrome.tabs.Tab
import chrome.tabs.UpdateProperties
import chrome.tabs.ZoomSettings
import chrome.windows.Window
import kotlinx.coroutines.await
import kotlin.js.collections.JsReadonlyArray

@Suppress("unused")
object KChromeTabs {

	/**
	 * The maximum number of times that {@link captureVisibleTab} can be called per second. {@link captureVisibleTab} is expensive and should not be called too often.
	 * @since Chrome 92
	 */
	val MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND: Any? by ChromeTabs::MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND

	/**
	 * An ID that represents the absence of a browser tab.
	 * @since Chrome 46
	 */
	val TAB_ID_NONE: Any? by ChromeTabs::TAB_ID_NONE

	/**
	 * An index that represents the absence of a tab index in a tab_strip.
	 * @since Chrome 123
	 */
	val TAB_INDEX_NONE: Any? by ChromeTabs::TAB_INDEX_NONE

	/**
	 * Injects JavaScript code into a page. For details, see the programmatic injection section of the content scripts doc.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 *
	 * MV2 only
	 * @param tabId The ID of the tab in which to run the script; defaults to the active tab of the current window.
	 * @param details Details of the script to run. Either the code or the file property must be set, but both may not be set at the same time
	 * @deprecated since Chrome 99. Replaced by {@link scripting.executeScript} in Manifest V3.
	 */
	suspend fun executeScript(details: InjectDetails): JsReadonlyArray<Any?>? = ChromeTabs.executeScript(details).await()
	suspend fun executeScript(tabId: Int?, details: InjectDetails): JsReadonlyArray<Any?>? = ChromeTabs.executeScript(tabId, details).await()

	/**
	 * Retrieves details about the specified tab
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun get(tabId: Int): Tab = ChromeTabs.get(tabId).await()

	/**
	 * Gets details about all tabs in the specified window.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 *
	 * MV2 only
	 * @deprecated Please use {@link tabs.query} `{windowId: windowId}`.
	 */
	suspend fun getAllInWindow(windowId: Int): JsReadonlyArray<Tab> = ChromeTabs.getAllInWindow(windowId).await()

	/**
	 * Gets the tab that this script call is being made from. Returns `undefined` if called from a non-tab context (for example, a background page or popup view).
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun getCurrent(): Tab? = ChromeTabs.getCurrent().await()

	/**
	 * Gets the tab that is selected in the specified window.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 *
	 * MV2 only
	 * @param windowId Defaults to the current window.
	 * @deprecated Please use {@link tabs.query} `{active: true}`.
	 */
	suspend fun getSelected(): Tab = ChromeTabs.getSelected().await()
	suspend fun getSelected(windowId: Int): Tab = ChromeTabs.getSelected(windowId).await()

	/**
	 * Creates a new tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun create(createProperties: CreateProperties): Tab = ChromeTabs.create(createProperties).await()

	/**
	 * Moves one or more tabs to a new position within its window, or to a new window. Note that tabs can only be moved to and from normal (window.type === "normal") windows.
	 * @param tabId The tab ID to move.
	 * @param tabIds List of tab IDs to move.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun move(tabId: Int, moveProperties: MoveProperties): Tab = ChromeTabs.move(tabId, moveProperties).await()
	suspend fun move(tabIds: JsReadonlyArray<Int>, moveProperties: MoveProperties): JsReadonlyArray<Tab> = ChromeTabs.move(tabIds, moveProperties).await()

	/**
	 * Modifies the properties of a tab. Properties that are not specified in `updateProperties` are not modified.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId Defaults to the selected tab of the current window.
	 */
	suspend fun update(tabId: Int, updateProperties: UpdateProperties): Tab? = ChromeTabs.update(tabId, updateProperties).await()
	suspend fun update(updateProperties: UpdateProperties): Tab? = ChromeTabs.update(updateProperties).await()

	/**
	 * Closes one or more tabs.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The tab ID to close.
	 * @param tabIds List of tab IDs to close.
	 */
	suspend fun remove(tabId: Int) = ChromeTabs.remove(tabId).await()
	suspend fun remove(tabIds: JsReadonlyArray<Int>) = ChromeTabs.remove(tabIds).await()

	/**
	 * Captures the visible area of the currently active tab in the specified window. In order to call this method, the extension must have either the [<all\_urls>](https://developer.chrome.com/extensions/develop/concepts/declare-permissions) permission or the [activeTab](https://developer.chrome.com/docs/extensions/develop/concepts/activeTab) permission. In addition to sites that extensions can normally access, this method allows extensions to capture sensitive sites that are otherwise restricted, including chrome:-scheme pages, other extensions' pages, and data: URLs. These sensitive sites can only be captured with the activeTab permission. File URLs may be captured only if the extension has been granted file access.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param windowId The target window. Defaults to the current window.
	 */
	suspend fun captureVisibleTab(): String = ChromeTabs.captureVisibleTab().await()
	suspend fun captureVisibleTab(windowId: Int): String = ChromeTabs.captureVisibleTab(windowId).await()
	suspend fun captureVisibleTab(options: ImageDetails): String = ChromeTabs.captureVisibleTab(options).await()
	suspend fun captureVisibleTab(windowId: Int, options: ImageDetails): String = ChromeTabs.captureVisibleTab(windowId, options).await()

	/**
	 * Reload a tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to reload; defaults to the selected tab of the current window.
	 */
	suspend fun reload() = ChromeTabs.reload().await()
	suspend fun reload(tabId: Int) = ChromeTabs.reload(tabId).await()
	suspend fun reload(reloadProperties: ReloadProperties) = ChromeTabs.reload(reloadProperties).await()
	suspend fun reload(tabId: Int, reloadProperties: ReloadProperties) = ChromeTabs.reload(tabId, reloadProperties).await()

	/**
	 * Duplicates a tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to duplicate.
	 */
	suspend fun duplicate(tabId: Int): Tab? = ChromeTabs.duplicate(tabId).await()

	/**
	 * Sends a single message to the content script(s) in the specified tab, with an optional callback to run when a response is sent back. The {@link runtime.onMessage} event is fired in each content script running in the specified tab for the current extension.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 99.
	 */
	suspend fun <
		MESSAGE /* default is Any? */,
		RESPONSE /* default is Any? */>
		sendMessage(tabId: Int, message: MESSAGE, options: MessageSendOptions): RESPONSE = ChromeTabs.sendMessage<MESSAGE, RESPONSE>(tabId, message, options).await()

	suspend fun <
		MESSAGE /* default is Any? */,
		RESPONSE /* default is Any? */
		>
		sendMessage(tabId: Int, message: MESSAGE): RESPONSE = ChromeTabs.sendMessage<MESSAGE, RESPONSE>(tabId, message).await()

	/**
	 * Sends a single request to the content script(s) in the specified tab, with an optional callback to run when a response is sent back. The {@link extension.onRequest} event is fired in each content script running in the specified tab for the current extension.
	 *
	 * MV2 only
	 * @deprecated Please use {@link runtime.sendMessage}.
	 */
	suspend fun <
		Request /* default is Any? */,
		Response /* default is Any? */
		>
		sendRequest(tabId: Int, request: Request): Response = ChromeTabs.sendRequest<Request, Response>(tabId, request).await()

	/**
	 * Connects to the content script(s) in the specified tab. The {@link runtime.onConnect} event is fired in each content script running in the specified tab for the current extension.
	 * @returns A port that can be used to communicate with the content scripts running in the specified tab. The port's {@link runtime.Port} event is fired if the tab closes or does not exist.
	 */
	fun connect(tabId: Int, connectInfo: ConnectInfo): Port = ChromeTabs.connect(tabId, connectInfo)
	fun connect(tabId: Int): Port = ChromeTabs.connect(tabId)

	/**
	 * Injects CSS into a page. Styles inserted with this method can be removed with {@link scripting.removeCSS}`. For details, see the programmatic injection section of the content scripts doc.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 *
	 * MV2 only
	 * @param tabId The ID of the tab in which to insert the CSS; defaults to the active tab of the current window.
	 * @param details Details of the CSS text to insert. Either the code or the file property must be set, but both may not be set at the same time.
	 * @deprecated since Chrome 99. Replaced by {@link scripting.insertCSS} in Manifest V3.
	 */
	suspend fun insertCSS(details: InjectDetails) = ChromeTabs.insertCSS(details).await()
	suspend fun insertCSS(tabId: Int, details: InjectDetails) = ChromeTabs.insertCSS(tabId, details).await()

	/**
	 * Highlights the given tabs and focuses on the first of group. Will appear to do nothing if the specified tab is currently active.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	suspend fun highlight(highlightInfo: HighlightInfo): Window = ChromeTabs.highlight(highlightInfo).await()

	/** Gets all tabs that have the specified properties, or all tabs if no properties are specified. */
	suspend fun query(queryInfo: QueryInfo): JsReadonlyArray<Tab> = ChromeTabs.query(queryInfo).await()

	/**
	 * Detects the primary language of the content in a tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to get the current zoom factor from; defaults to the active tab of the current window.
	 */
	suspend fun detectLanguage(): String = ChromeTabs.detectLanguage().await()
	suspend fun detectLanguage(tabId: Int): String = ChromeTabs.detectLanguage(tabId).await()

	/**
	 * Zooms a specified tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to zoom; defaults to the active tab of the current window.
	 * @param zoomFactor The new zoom factor. A value of `0` sets the tab to its current default zoom factor. Values greater than 0 specify a (possibly non-default) zoom factor for the tab.
	 */
	suspend fun setZoom(zoomFactor: Double) = ChromeTabs.setZoom(zoomFactor).await()
	suspend fun setZoom(tabId: Int, zoomFactor: Double) = ChromeTabs.setZoom(tabId, zoomFactor).await()

	/**
	 * Gets the current zoom factor of a specified tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to get the current zoom factor from; defaults to the active tab of the current window.
	 */
	suspend fun getZoom(): Double = ChromeTabs.getZoom().await()
	suspend fun getZoom(tabId: Int): Double = ChromeTabs.getZoom(tabId).await()

	/**
	 * Sets the zoom settings for a specified tab, which define how zoom changes are handled. These settings are reset to defaults upon navigating the tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to change the zoom settings for; defaults to the active tab of the current window.
	 * @param zoomSettings Defines how zoom changes are handled and at what scope.
	 */
	suspend fun setZoomSettings(zoomSettings: ZoomSettings) = ChromeTabs.setZoomSettings(zoomSettings).await()
	suspend fun setZoomSettings(tabId: Int?, zoomSettings: ZoomSettings) = ChromeTabs.setZoomSettings(zoomSettings).await()

	/**
	 * Gets the current zoom settings of a specified tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to get the current zoom settings from; defaults to the active tab of the current window.
	 */
	suspend fun getZoomSettings(): ZoomSettings = ChromeTabs.getZoomSettings().await()
	suspend fun getZoomSettings(tabId: Int): ZoomSettings = ChromeTabs.getZoomSettings(tabId).await()

	/**
	 * Discards a tab from memory. Discarded tabs are still visible on the tab strip and are reloaded when activated.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to be discarded. If specified, the tab is discarded unless it is active or already discarded. If omitted, the browser discards the least important tab. This can fail if no discardable tabs exist..
	 * @since Chrome 54
	 */
	suspend fun discard(): Tab? = ChromeTabs.discard().await()
	suspend fun discard(tabId: Int): Tab? = ChromeTabs.discard(tabId).await()

	/**
	 * Go forward to the next page, if one is available.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to navigate forward; defaults to the selected tab of the current window.
	 * @since Chrome 72
	 */
	suspend fun goForward() = ChromeTabs.goForward().await()
	suspend fun goForward(tabId: Int) = ChromeTabs.goForward(tabId).await()

	/**
	 * Go back to the previous page, if one is available.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to navigate back; defaults to the selected tab of the current window.
	 * @since Chrome 72
	 */
	suspend fun goBack() = ChromeTabs.goBack().await()
	suspend fun goBack(tabId: Int) = ChromeTabs.goBack(tabId).await()

	/**
	 * Adds one or more tabs to a specified group, or if no group is specified, adds the given tabs to a newly created group.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @since Chrome 88
	 */
	suspend fun group(options: GroupOptions): Int = ChromeTabs.group(options).await()

	/**
	 * Removes one or more tabs from their respective groups. If any groups become empty, they are deleted
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabIds The tab ID or list of tab IDs to remove from their respective groups.
	 * @since Chrome 88
	 */
	suspend fun ungroup(tabIds: Int) = ChromeTabs.ungroup(tabIds).await()

	/**
	 * Removes one or more tabs from their respective groups. If any groups become empty, they are deleted
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabIds The tab ID or list of tab IDs to remove from their respective groups.
	 * @since Chrome 88
	 */
	suspend fun ungroup(tabIds: IntArray) = ChromeTabs.ungroup(tabIds).await()

	/** Fired when the highlighted or selected tabs in a window changes */
	val onHighlighted: Event<(highlightInfo: OnHighlightedInfo) -> Unit> by ChromeTabs::onHighlighted

	/** Fired when a tab is closed. */
	val onRemoved: Event<(tabId: Int, removeInfo: OnRemovedInfo) -> Unit> by ChromeTabs::onRemoved

	/** Fired when a tab is updated. */
	val onUpdated: Event<(tabId: Int, changeInfo: OnUpdatedInfo, tab: Tab) -> Unit> by ChromeTabs::onUpdated

	/** Fired when a tab is attached to a window, for example because it was moved between windows. */
	val onAttached: Event<(tabId: Int, attachInfo: OnAttachedInfo) -> Unit> by ChromeTabs::onAttached

	/** Fired when a tab is moved within a window. Only one move event is fired, representing the tab the user directly moved. Move events are not fired for the other tabs that must move in response to the manually-moved tab. This event is not fired when a tab is moved between windows; for details, see {@link tabs.onDetached}. */
	val onMoved: Event<(tabId: Int, moveInfo: OnMovedInfo) -> Unit> by ChromeTabs::onMoved

	/** Fired when a tab is detached from a window; for example, because it was moved between windows. */
	val onDetached: Event<(tabId: Int, detachInfo: OnDetachedInfo) -> Unit> by ChromeTabs::onDetached

	/** Fired when a tab is created. Note that the tab's URL and tab group membership may not be set at the time this event is fired, but you can listen to onUpdated events so as to be notified when a URL is set or the tab is added to a tab group. */
	val onCreated: Event<(tab: Tab) -> Unit> by ChromeTabs::onCreated

	/** Fires when the active tab in a window changes. Note that the tab's URL may not be set at the time this event fired, but you can listen to onUpdated events so as to be notified when a URL is set */
	val onActivated: Event<(activeInfo: OnActivatedInfo) -> Unit> by ChromeTabs::onActivated

	/** Fired when a tab is replaced with another tab due to prerendering or instant */
	val onReplaced: Event<(addedTabId: Int, removedTabId: Int) -> Unit> by ChromeTabs::onReplaced

	/**
	 * Fires when the selected tab in a window changes.
	 *
	 * MV2 only
	 * @deprecated Please use {@link tabs.onActivated}.
	 */
	val onSelectionChanged: Event<(tabId: Int, selectInfo: OnSelectionChangedInfo) -> Unit> by ChromeTabs::onSelectionChanged

	/**
	 * Fires when the selected tab in a window changes. Note that the tab's URL may not be set at the time this event fired, but you can listen to {@link tabs.onUpdated} events so as to be notified when a URL is set.
	 *
	 * MV2 only
	 * @deprecated Please use {@link tabs.onActivated}.
	 */
	val onActiveChanged: Event<(tabId: Int, selectInfo: OnActiveChangedInfo) -> Unit> by ChromeTabs::onActiveChanged

	/**
	 * Fired when the highlighted or selected tabs in a window changes.
	 *
	 * MV2 only
	 * @deprecated Please use {@link tabs.onHighlighted}.
	 */
	val onHighlightChanged: Event<(selectInfo: OnHighlightChangedInfo) -> Unit> by ChromeTabs::onHighlightChanged

	/** Fired when a tab is zoomed */
	val onZoomChange: Event<(zoomChangeInfo: OnZoomChangeInfo) -> Unit> by ChromeTabs::onZoomChange
}