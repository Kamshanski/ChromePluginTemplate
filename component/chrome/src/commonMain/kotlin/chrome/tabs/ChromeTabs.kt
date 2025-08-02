@file:JsQualifier("chrome")

package chrome.tabs

import chrome.events.Event
import chrome.extensiontypes.ImageDetails
import chrome.extensiontypes.InjectDetails
import chrome.runtime.Port
import chrome.windows.Window
import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

@Suppress("unused")
@JsName("tabs")
external object ChromeTabs {

	/**
	 * The maximum number of times that {@link captureVisibleTab} can be called per second. {@link captureVisibleTab} is expensive and should not be called too often.
	 * @since Chrome 92
	 */
	val MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND: Any? /* should be inferred */

	/**
	 * An ID that represents the absence of a browser tab.
	 * @since Chrome 46
	 */
	val TAB_ID_NONE: Any? /* should be inferred */

	/**
	 * An index that represents the absence of a tab index in a tab_strip.
	 * @since Chrome 123
	 */
	val TAB_INDEX_NONE: Any? /* should be inferred */

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
	fun executeScript(details: InjectDetails): Promise<JsReadonlyArray<Any?>?>
	fun executeScript(tabId: Int?, details: InjectDetails): Promise<JsReadonlyArray<Any?>?>
	fun executeScript(details: InjectDetails, callback: (result: JsReadonlyArray<Any?>? /* use undefined for default */) -> Unit)
	fun executeScript(tabId: Int?, details: InjectDetails, callback: (result: JsReadonlyArray<Any?>? /* use undefined for default */) -> Unit)

	/**
	 * Retrieves details about the specified tab
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun get(tabId: Int): Promise<Tab>
	fun get(tabId: Int, callback: (tab: Tab) -> Unit)

	/**
	 * Gets details about all tabs in the specified window.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 *
	 * MV2 only
	 * @deprecated Please use {@link tabs.query} `{windowId: windowId}`.
	 */
	fun getAllInWindow(windowId: Int = definedExternally): Promise<JsReadonlyArray<Tab>>
	fun getAllInWindow(callback: (tabs: JsReadonlyArray<Tab>) -> Unit)
	fun getAllInWindow(windowId: Int?, callback: (tabs: JsReadonlyArray<Tab>) -> Unit)

	/**
	 * Gets the tab that this script call is being made from. Returns `undefined` if called from a non-tab context (for example, a background page or popup view).
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun getCurrent(): Promise<Tab?>
	fun getCurrent(callback: (tab: Tab? /* use undefined for default */) -> Unit)

	/**
	 * Gets the tab that is selected in the specified window.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 *
	 * MV2 only
	 * @param windowId Defaults to the current window.
	 * @deprecated Please use {@link tabs.query} `{active: true}`.
	 */
	fun getSelected(windowId: Int = definedExternally): Promise<Tab>
	fun getSelected(callback: (tab: Tab) -> Unit)
	fun getSelected(windowId: Int?, callback: (tab: Tab) -> Unit)

	/**
	 * Creates a new tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun create(createProperties: CreateProperties): Promise<Tab>
	fun create(createProperties: CreateProperties, callback: (tab: Tab) -> Unit)

	/**
	 * Moves one or more tabs to a new position within its window, or to a new window. Note that tabs can only be moved to and from normal (window.type === "normal") windows.
	 * @param tabId The tab ID to move.
	 * @param tabIds List of tab IDs to move.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun move(tabId: Int, moveProperties: MoveProperties): Promise<Tab>
	fun move(tabIds: JsReadonlyArray<Int>, moveProperties: MoveProperties): Promise<JsReadonlyArray<Tab>>
	fun move(tabId: Int, moveProperties: MoveProperties, callback: (tab: Tab) -> Unit)
	fun move(tabIds: JsReadonlyArray<Int>, moveProperties: MoveProperties, callback: (tabs: JsReadonlyArray<Tab>) -> Unit)

	/**
	 * Modifies the properties of a tab. Properties that are not specified in `updateProperties` are not modified.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId Defaults to the selected tab of the current window.
	 */
	fun update(updateProperties: UpdateProperties): Promise<Tab?>
	fun update(tabId: Int?, updateProperties: UpdateProperties): Promise<Tab?>
	fun update(updateProperties: UpdateProperties, callback: (tab: Tab? /* use undefined for default */) -> Unit)
	fun update(tabId: Int?, updateProperties: UpdateProperties, callback: (tab: Tab? /* use undefined for default */) -> Unit)

	/**
	 * Closes one or more tabs.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The tab ID to close.
	 * @param tabIds List of tab IDs to close.
	 */
	fun remove(tabId: Int): Promise<Unit>
	fun remove(tabIds: JsReadonlyArray<Int>): Promise<Unit>
	fun remove(tabId: Int, callback: () -> Unit)
	fun remove(tabIds: JsReadonlyArray<Int>, callback: () -> Unit)

	/**
	 * Captures the visible area of the currently active tab in the specified window. In order to call this method, the extension must have either the [<all\_urls>](https://developer.chrome.com/extensions/develop/concepts/declare-permissions) permission or the [activeTab](https://developer.chrome.com/docs/extensions/develop/concepts/activeTab) permission. In addition to sites that extensions can normally access, this method allows extensions to capture sensitive sites that are otherwise restricted, including chrome:-scheme pages, other extensions' pages, and data: URLs. These sensitive sites can only be captured with the activeTab permission. File URLs may be captured only if the extension has been granted file access.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param windowId The target window. Defaults to the current window.
	 */
	fun captureVisibleTab(): Promise<String>
	fun captureVisibleTab(windowId: Int): Promise<String>
	fun captureVisibleTab(options: ImageDetails): Promise<String>
	fun captureVisibleTab(windowId: Int, options: ImageDetails): Promise<String>
	fun captureVisibleTab(callback: (dataUrl: String) -> Unit)
	fun captureVisibleTab(windowId: Int, callback: (dataUrl: String) -> Unit)
	fun captureVisibleTab(options: ImageDetails, callback: (dataUrl: String) -> Unit)
	fun captureVisibleTab(windowId: Int, options: ImageDetails, callback: (dataUrl: String) -> Unit)

	/**
	 * Reload a tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to reload; defaults to the selected tab of the current window.
	 */
	fun reload(): Promise<Unit>
	fun reload(tabId: Int): Promise<Unit>
	fun reload(reloadProperties: ReloadProperties): Promise<Unit>
	fun reload(tabId: Int, reloadProperties: ReloadProperties): Promise<Unit>
	fun reload(callback: () -> Unit)
	fun reload(tabId: Int?, callback: () -> Unit)
	fun reload(reloadProperties: ReloadProperties?, callback: () -> Unit)
	fun reload(tabId: Int?, reloadProperties: ReloadProperties?, callback: () -> Unit)

	/**
	 * Duplicates a tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to duplicate.
	 */
	fun duplicate(tabId: Int): Promise<Tab?>
	fun duplicate(tabId: Int, callback: (tab: Tab? /* use undefined for default */) -> Unit)

	/**
	 * Sends a single message to the content script(s) in the specified tab, with an optional callback to run when a response is sent back. The {@link runtime.onMessage} event is fired in each content script running in the specified tab for the current extension.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 99.
	 */
	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(tabId: Int, message: M, options: MessageSendOptions = definedExternally): Promise<R>
	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(
		tabId: Int, message: M,
		/** @since Chrome 99 */
		callback: (response: R) -> Unit
	)

	fun <M /* default is Any? */, R /* default is Any? */> sendMessage(
		tabId: Int, message: M, options: MessageSendOptions?,
		/** @since Chrome 99 */
		callback: (response: R) -> Unit
	)

	/**
	 * Sends a single request to the content script(s) in the specified tab, with an optional callback to run when a response is sent back. The {@link extension.onRequest} event is fired in each content script running in the specified tab for the current extension.
	 *
	 * MV2 only
	 * @deprecated Please use {@link runtime.sendMessage}.
	 */
	fun <Request /* default is Any? */, Response /* default is Any? */> sendRequest(tabId: Int, request: Request): Promise<Response>
	fun <Request /* default is Any? */, Response /* default is Any? */> sendRequest(
		tabId: Int, request: Request,
		/** @since Chrome 99 */
		callback: (response: Response) -> Unit = definedExternally
	)

	/**
	 * Connects to the content script(s) in the specified tab. The {@link runtime.onConnect} event is fired in each content script running in the specified tab for the current extension.
	 * @returns A port that can be used to communicate with the content scripts running in the specified tab. The port's {@link runtime.Port} event is fired if the tab closes or does not exist.
	 */
	fun connect(tabId: Int, connectInfo: ConnectInfo = definedExternally): Port

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
	fun insertCSS(details: InjectDetails): Promise<Unit>
	fun insertCSS(details: InjectDetails, callback: () -> Unit)
	fun insertCSS(tabId: Int?, details: InjectDetails): Promise<Unit>
	fun insertCSS(tabId: Int, details: InjectDetails, callback: () -> Unit)

	/**
	 * Highlights the given tabs and focuses on the first of group. Will appear to do nothing if the specified tab is currently active.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 */
	fun highlight(highlightInfo: HighlightInfo): Promise<Window>
	fun highlight(highlightInfo: HighlightInfo, callback: (window: Window) -> Unit)

	/** Gets all tabs that have the specified properties, or all tabs if no properties are specified. */
	fun query(queryInfo: QueryInfo): Promise<JsReadonlyArray<Tab>>
	fun query(queryInfo: QueryInfo, callback: (result: JsReadonlyArray<Tab>) -> Unit)

	/**
	 * Detects the primary language of the content in a tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to get the current zoom factor from; defaults to the active tab of the current window.
	 */
	fun detectLanguage(tabId: Int = definedExternally): Promise<String>
	fun detectLanguage(callback: (language: String) -> Unit)
	fun detectLanguage(tabId: Int?, callback: (language: String) -> Unit)

	/**
	 * Zooms a specified tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to zoom; defaults to the active tab of the current window.
	 * @param zoomFactor The new zoom factor. A value of `0` sets the tab to its current default zoom factor. Values greater than 0 specify a (possibly non-default) zoom factor for the tab.
	 */
	fun setZoom(zoomFactor: Double): Promise<Unit>
	fun setZoom(tabId: Int?, zoomFactor: Double): Promise<Unit>
	fun setZoom(zoomFactor: Double, callback: () -> Unit)
	fun setZoom(tabId: Int?, zoomFactor: Double, callback: () -> Unit)

	/**
	 * Gets the current zoom factor of a specified tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to get the current zoom factor from; defaults to the active tab of the current window.
	 */
	fun getZoom(tabId: Int = definedExternally): Promise<Double>
	fun getZoom(callback: (zoomFactor: Double) -> Unit)
	fun getZoom(tabId: Int?, callback: (zoomFactor: Double) -> Unit)

	/**
	 * Sets the zoom settings for a specified tab, which define how zoom changes are handled. These settings are reset to defaults upon navigating the tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to change the zoom settings for; defaults to the active tab of the current window.
	 * @param zoomSettings Defines how zoom changes are handled and at what scope.
	 */
	fun setZoomSettings(zoomSettings: ZoomSettings): Promise<Unit>
	fun setZoomSettings(tabId: Int?, zoomSettings: ZoomSettings): Promise<Unit>
	fun setZoomSettings(zoomSettings: ZoomSettings, callback: () -> Unit)
	fun setZoomSettings(tabId: Int?, zoomSettings: ZoomSettings, callback: () -> Unit)

	/**
	 * Gets the current zoom settings of a specified tab.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to get the current zoom settings from; defaults to the active tab of the current window.
	 */
	fun getZoomSettings(tabId: Int = definedExternally): Promise<ZoomSettings>
	fun getZoomSettings(callback: (zoomSettings: ZoomSettings) -> Unit)
	fun getZoomSettings(tabId: Int?, callback: (zoomSettings: ZoomSettings) -> Unit)

	/**
	 * Discards a tab from memory. Discarded tabs are still visible on the tab strip and are reloaded when activated.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to be discarded. If specified, the tab is discarded unless it is active or already discarded. If omitted, the browser discards the least important tab. This can fail if no discardable tabs exist..
	 * @since Chrome 54
	 */
	fun discard(tabId: Int = definedExternally): Promise<Tab?>
	fun discard(callback: (tab: Tab? /* use undefined for default */) -> Unit)
	fun discard(tabId: Int?, callback: (tab: Tab? /* use undefined for default */) -> Unit)

	/**
	 * Go forward to the next page, if one is available.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to navigate forward; defaults to the selected tab of the current window.
	 * @since Chrome 72
	 */
	fun goForward(tabId: Int = definedExternally): Promise<Unit>
	fun goForward(callback: () -> Unit)
	fun goForward(tabId: Int?, callback: () -> Unit)

	/**
	 * Go back to the previous page, if one is available.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabId The ID of the tab to navigate back; defaults to the selected tab of the current window.
	 * @since Chrome 72
	 */
	fun goBack(tabId: Int = definedExternally): Promise<Unit>
	fun goBack(callback: () -> Unit)
	fun goBack(tabId: Int?, callback: () -> Unit)

	/**
	 * Adds one or more tabs to a specified group, or if no group is specified, adds the given tabs to a newly created group.
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @since Chrome 88
	 */
	fun group(options: GroupOptions): Promise<Int>
	fun group(options: GroupOptions, callback: (groupId: Int) -> Unit)

	/**
	 * Removes one or more tabs from their respective groups. If any groups become empty, they are deleted
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabIds The tab ID or list of tab IDs to remove from their respective groups.
	 * @since Chrome 88
	 */
	fun ungroup(tabIds: Int): Promise<Unit>

	/**
	 * Removes one or more tabs from their respective groups. If any groups become empty, they are deleted
	 *
	 * Can return its result via Promise in Manifest V3 or later since Chrome 88.
	 * @param tabIds The tab ID or list of tab IDs to remove from their respective groups.
	 * @since Chrome 88
	 */
	fun ungroup(tabIds: IntArray): Promise<Unit>

	fun ungroup(tabIds: Int, callback: () -> Unit)

	fun ungroup(tabIds: IntArray, callback: () -> Unit)

	/** Fired when the highlighted or selected tabs in a window changes */
	val onHighlighted: Event<(highlightInfo: OnHighlightedInfo) -> Unit>

	/** Fired when a tab is closed. */
	val onRemoved: Event<(tabId: Int, removeInfo: OnRemovedInfo) -> Unit>

	/** Fired when a tab is updated. */
	val onUpdated: Event<(tabId: Int, changeInfo: OnUpdatedInfo, tab: Tab) -> Unit>

	/** Fired when a tab is attached to a window, for example because it was moved between windows. */
	val onAttached: Event<(tabId: Int, attachInfo: OnAttachedInfo) -> Unit>

	/** Fired when a tab is moved within a window. Only one move event is fired, representing the tab the user directly moved. Move events are not fired for the other tabs that must move in response to the manually-moved tab. This event is not fired when a tab is moved between windows; for details, see {@link tabs.onDetached}. */
	val onMoved: Event<(tabId: Int, moveInfo: OnMovedInfo) -> Unit>

	/** Fired when a tab is detached from a window; for example, because it was moved between windows. */
	val onDetached: Event<(tabId: Int, detachInfo: OnDetachedInfo) -> Unit>

	/** Fired when a tab is created. Note that the tab's URL and tab group membership may not be set at the time this event is fired, but you can listen to onUpdated events so as to be notified when a URL is set or the tab is added to a tab group. */
	val onCreated: Event<(tab: Tab) -> Unit>

	/** Fires when the active tab in a window changes. Note that the tab's URL may not be set at the time this event fired, but you can listen to onUpdated events so as to be notified when a URL is set */
	val onActivated: Event<(activeInfo: OnActivatedInfo) -> Unit>

	/** Fired when a tab is replaced with another tab due to prerendering or instant */
	val onReplaced: Event<(addedTabId: Int, removedTabId: Int) -> Unit>

	/**
	 * Fires when the selected tab in a window changes.
	 *
	 * MV2 only
	 * @deprecated Please use {@link tabs.onActivated}.
	 */
	val onSelectionChanged: Event<(tabId: Int, selectInfo: OnSelectionChangedInfo) -> Unit>

	/**
	 * Fires when the selected tab in a window changes. Note that the tab's URL may not be set at the time this event fired, but you can listen to {@link tabs.onUpdated} events so as to be notified when a URL is set.
	 *
	 * MV2 only
	 * @deprecated Please use {@link tabs.onActivated}.
	 */
	val onActiveChanged: Event<(tabId: Int, selectInfo: OnActiveChangedInfo) -> Unit>

	/**
	 * Fired when the highlighted or selected tabs in a window changes.
	 *
	 * MV2 only
	 * @deprecated Please use {@link tabs.onHighlighted}.
	 */
	val onHighlightChanged: Event<(selectInfo: OnHighlightChangedInfo) -> Unit>

	/** Fired when a tab is zoomed */
	val onZoomChange: Event<(zoomChangeInfo: OnZoomChangeInfo) -> Unit>
}