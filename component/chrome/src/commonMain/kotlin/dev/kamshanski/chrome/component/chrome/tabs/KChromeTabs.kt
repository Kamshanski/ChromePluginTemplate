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
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await

@OptIn(ExperimentalJsExport::class)
@Suppress("unused")
interface KChromeTabs {
	companion object : KChromeTabs{

		override val MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND: Any? by ChromeTabs::MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND

		override val TAB_ID_NONE: Any? by ChromeTabs::TAB_ID_NONE

		override val TAB_INDEX_NONE: Any? by ChromeTabs::TAB_INDEX_NONE

		override val onHighlighted: Event<(highlightInfo: OnHighlightedInfo) -> Unit> by ChromeTabs::onHighlighted

		override val onRemoved: Event<(tabId: Int, removeInfo: OnRemovedInfo) -> Unit> by ChromeTabs::onRemoved

		override val onUpdated: Event<(tabId: Int, changeInfo: OnUpdatedInfo, tab: Tab) -> Unit> by ChromeTabs::onUpdated

		override val onAttached: Event<(tabId: Int, attachInfo: OnAttachedInfo) -> Unit> by ChromeTabs::onAttached

		override val onMoved: Event<(tabId: Int, moveInfo: OnMovedInfo) -> Unit> by ChromeTabs::onMoved

		override val onDetached: Event<(tabId: Int, detachInfo: OnDetachedInfo) -> Unit> by ChromeTabs::onDetached

		override val onCreated: Event<(tab: Tab) -> Unit> by ChromeTabs::onCreated

		override val onActivated: Event<(activeInfo: OnActivatedInfo) -> Unit> by ChromeTabs::onActivated

		override val onReplaced: Event<(addedTabId: Int, removedTabId: Int) -> Unit> by ChromeTabs::onReplaced

		override val onSelectionChanged: Event<(tabId: Int, selectInfo: OnSelectionChangedInfo) -> Unit> by ChromeTabs::onSelectionChanged

		override val onActiveChanged: Event<(tabId: Int, selectInfo: OnActiveChangedInfo) -> Unit> by ChromeTabs::onActiveChanged

		override val onHighlightChanged: Event<(selectInfo: OnHighlightChangedInfo) -> Unit> by ChromeTabs::onHighlightChanged

		override val onZoomChange: Event<(zoomChangeInfo: OnZoomChangeInfo) -> Unit> by ChromeTabs::onZoomChange

		override suspend fun executeScript(tabId: Int?, details: InjectDetails): List<Any?>? = ChromeTabs.executeScript(tabId, details).await()?.asList()
		override suspend fun executeScript(details: InjectDetails): List<Any?>? = ChromeTabs.executeScript(details).await()?.asList()

		override suspend fun get(tabId: Int): Tab = ChromeTabs.get(tabId).await()

		override suspend fun getAllInWindow(windowId: Int): List<Tab> = ChromeTabs.getAllInWindow(windowId).await().asList()

		override suspend fun getCurrent(): Tab? = ChromeTabs.getCurrent().await()

		override suspend fun getSelected(windowId: Int): Tab = ChromeTabs.getSelected(windowId).await()
		override suspend fun getSelected(): Tab = ChromeTabs.getSelected().await()

		override suspend fun create(createProperties: CreateProperties): Tab = ChromeTabs.create(createProperties).await()

		override suspend fun move(tabIds: List<Int>, moveProperties: MoveProperties): List<Tab> = ChromeTabs.move(tabIds.asJsReadonlyArrayView(), moveProperties).await().asList()
		override suspend fun move(tabId: Int, moveProperties: MoveProperties): Tab = ChromeTabs.move(tabId, moveProperties).await()

		override suspend fun update(tabId: Int, updateProperties: UpdateProperties): Tab? = ChromeTabs.update(tabId, updateProperties).await()
		override suspend fun update(updateProperties: UpdateProperties): Tab? = ChromeTabs.update(updateProperties).await()

		override suspend fun remove(tabId: Int) = ChromeTabs.remove(tabId).await()
		override suspend fun remove(tabIds: List<Int>) = ChromeTabs.remove(tabIds.asJsReadonlyArrayView()).await()

		override suspend fun captureVisibleTab(): String = ChromeTabs.captureVisibleTab().await()
		override suspend fun captureVisibleTab(windowId: Int): String = ChromeTabs.captureVisibleTab(windowId).await()
		override suspend fun captureVisibleTab(options: ImageDetails): String = ChromeTabs.captureVisibleTab(options).await()
		override suspend fun captureVisibleTab(windowId: Int, options: ImageDetails): String = ChromeTabs.captureVisibleTab(windowId, options).await()

		override suspend fun reload() = ChromeTabs.reload().await()
		override suspend fun reload(tabId: Int) = ChromeTabs.reload(tabId).await()
		override suspend fun reload(reloadProperties: ReloadProperties) = ChromeTabs.reload(reloadProperties).await()
		override suspend fun reload(tabId: Int, reloadProperties: ReloadProperties) = ChromeTabs.reload(tabId, reloadProperties).await()

		override suspend fun duplicate(tabId: Int): Tab? = ChromeTabs.duplicate(tabId).await()

		override suspend fun <
	 		MESSAGE /* default is Any? */,
	 		RESPONSE /* default is Any? */
	 		>
	 		sendMessage(tabId: Int, message: MESSAGE, options: MessageSendOptions): RESPONSE = ChromeTabs.sendMessage<MESSAGE, RESPONSE>(tabId, message, options).await()

		override suspend fun <
	 		MESSAGE /* default is Any? */,
	 		RESPONSE /* default is Any? */
	 		>
	 		sendMessage(tabId: Int, message: MESSAGE): RESPONSE = ChromeTabs.sendMessage<MESSAGE, RESPONSE>(tabId, message).await()

		override suspend fun <
			Request /* default is Any? */,
			Response /* default is Any? */
			>
			sendRequest(tabId: Int, request: Request): Response = ChromeTabs.sendRequest<Request, Response>(tabId, request).await()

		override fun connect(tabId: Int, connectInfo: ConnectInfo): Port = ChromeTabs.connect(tabId, connectInfo)
		override fun connect(tabId: Int): Port = ChromeTabs.connect(tabId)

		override suspend fun insertCSS(details: InjectDetails) = ChromeTabs.insertCSS(details).await()
		override suspend fun insertCSS(tabId: Int, details: InjectDetails) = ChromeTabs.insertCSS(tabId, details).await()

		override suspend fun highlight(highlightInfo: HighlightInfo): Window = ChromeTabs.highlight(highlightInfo).await()

		override suspend fun query(queryInfo: QueryInfo): List<Tab> = ChromeTabs.query(queryInfo).await().asList()

		override suspend fun detectLanguage(): String = ChromeTabs.detectLanguage().await()
		override suspend fun detectLanguage(tabId: Int): String = ChromeTabs.detectLanguage(tabId).await()

		override suspend fun setZoom(zoomFactor: Double) = ChromeTabs.setZoom(zoomFactor).await()
		override suspend fun setZoom(tabId: Int, zoomFactor: Double) = ChromeTabs.setZoom(tabId, zoomFactor).await()

		override suspend fun getZoom(): Double = ChromeTabs.getZoom().await()
		override suspend fun getZoom(tabId: Int): Double = ChromeTabs.getZoom(tabId).await()

		override suspend fun setZoomSettings(zoomSettings: ZoomSettings) = ChromeTabs.setZoomSettings(zoomSettings).await()
		override suspend fun setZoomSettings(tabId: Int?, zoomSettings: ZoomSettings) = ChromeTabs.setZoomSettings(zoomSettings).await()

		override suspend fun getZoomSettings(): ZoomSettings = ChromeTabs.getZoomSettings().await()
		override suspend fun getZoomSettings(tabId: Int): ZoomSettings = ChromeTabs.getZoomSettings(tabId).await()

		override suspend fun discard(): Tab? = ChromeTabs.discard().await()
		override suspend fun discard(tabId: Int): Tab? = ChromeTabs.discard(tabId).await()

		override suspend fun goForward() = ChromeTabs.goForward().await()
		override suspend fun goForward(tabId: Int) = ChromeTabs.goForward(tabId).await()

		override suspend fun goBack() = ChromeTabs.goBack().await()
		override suspend fun goBack(tabId: Int) = ChromeTabs.goBack(tabId).await()

		override suspend fun group(options: GroupOptions): Int = ChromeTabs.group(options).await()

		override suspend fun ungroup(tabIds: Int) = ChromeTabs.ungroup(tabIds).await()
		override suspend fun ungroup(tabIds: IntArray) = ChromeTabs.ungroup(tabIds).await()

	}

	val MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND: Any?

	val TAB_ID_NONE: Any?

	val TAB_INDEX_NONE: Any?

	val onHighlighted: Event<(highlightInfo: OnHighlightedInfo) -> Unit>

	val onRemoved: Event<(tabId: Int, removeInfo: OnRemovedInfo) -> Unit>

	val onUpdated: Event<(tabId: Int, changeInfo: OnUpdatedInfo, tab: Tab) -> Unit>

	val onAttached: Event<(tabId: Int, attachInfo: OnAttachedInfo) -> Unit>

	val onMoved: Event<(tabId: Int, moveInfo: OnMovedInfo) -> Unit>

	val onDetached: Event<(tabId: Int, detachInfo: OnDetachedInfo) -> Unit>

	val onCreated: Event<(tab: Tab) -> Unit>

	val onActivated: Event<(activeInfo: OnActivatedInfo) -> Unit>

	val onReplaced: Event<(addedTabId: Int, removedTabId: Int) -> Unit>

	val onSelectionChanged: Event<(tabId: Int, selectInfo: OnSelectionChangedInfo) -> Unit>

	val onActiveChanged: Event<(tabId: Int, selectInfo: OnActiveChangedInfo) -> Unit>

	val onHighlightChanged: Event<(selectInfo: OnHighlightChangedInfo) -> Unit>

	val onZoomChange: Event<(zoomChangeInfo: OnZoomChangeInfo) -> Unit>

	suspend fun executeScript(tabId: Int?, details: InjectDetails): List<Any?>?
	suspend fun executeScript(details: InjectDetails): List<Any?>?

	suspend fun get(tabId: Int): Tab

	suspend fun getAllInWindow(windowId: Int): List<Tab>

	suspend fun getCurrent(): Tab?

	suspend fun getSelected(windowId: Int): Tab
	suspend fun getSelected(): Tab

	suspend fun create(createProperties: CreateProperties): Tab

	suspend fun move(tabIds: List<Int>, moveProperties: MoveProperties): List<Tab>
	suspend fun move(tabId: Int, moveProperties: MoveProperties): Tab

	suspend fun update(tabId: Int, updateProperties: UpdateProperties): Tab?
	suspend fun update(updateProperties: UpdateProperties): Tab?

	suspend fun remove(tabId: Int)
	suspend fun remove(tabIds: List<Int>)

	suspend fun captureVisibleTab(): String
	suspend fun captureVisibleTab(windowId: Int): String
	suspend fun captureVisibleTab(options: ImageDetails): String
	suspend fun captureVisibleTab(windowId: Int, options: ImageDetails): String

	suspend fun reload()
	suspend fun reload(tabId: Int)
	suspend fun reload(reloadProperties: ReloadProperties)
	suspend fun reload(tabId: Int, reloadProperties: ReloadProperties)

	suspend fun duplicate(tabId: Int): Tab?

	suspend fun <
		MESSAGE /* default is Any? */,
		RESPONSE /* default is Any? */
		>
		sendMessage(tabId: Int, message: MESSAGE, options: MessageSendOptions): RESPONSE

	suspend fun <
		MESSAGE /* default is Any? */,
		RESPONSE /* default is Any? */
		>
		sendMessage(tabId: Int, message: MESSAGE): RESPONSE

	suspend fun <
		Request /* default is Any? */,
		Response /* default is Any? */
		>
		sendRequest(tabId: Int, request: Request): Response

	fun connect(tabId: Int, connectInfo: ConnectInfo): Port
	fun connect(tabId: Int): Port

	suspend fun insertCSS(details: InjectDetails)
	suspend fun insertCSS(tabId: Int, details: InjectDetails)

	suspend fun highlight(highlightInfo: HighlightInfo): Window

	suspend fun query(queryInfo: QueryInfo): List<Tab>

	suspend fun detectLanguage(): String
	suspend fun detectLanguage(tabId: Int): String

	suspend fun setZoom(zoomFactor: Double)
	suspend fun setZoom(tabId: Int, zoomFactor: Double)

	suspend fun getZoom(): Double
	suspend fun getZoom(tabId: Int): Double

	suspend fun setZoomSettings(zoomSettings: ZoomSettings)
	suspend fun setZoomSettings(tabId: Int?, zoomSettings: ZoomSettings)

	suspend fun getZoomSettings(): ZoomSettings
	suspend fun getZoomSettings(tabId: Int): ZoomSettings

	suspend fun discard(): Tab?
	suspend fun discard(tabId: Int): Tab?

	suspend fun goForward()
	suspend fun goForward(tabId: Int)

	suspend fun goBack()
	suspend fun goBack(tabId: Int)

	suspend fun group(options: GroupOptions): Int

	suspend fun ungroup(tabIds: Int)
	suspend fun ungroup(tabIds: IntArray)
}