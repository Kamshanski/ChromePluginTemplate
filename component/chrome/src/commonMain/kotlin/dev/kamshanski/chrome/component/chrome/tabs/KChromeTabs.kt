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

/** @see ChromeTabs */
interface KChromeTabs {

	companion object : KChromeTabs {

		/** @see ChromeTabs.MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND */
		override val MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND: Any? by ChromeTabs::MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND

		/** @see ChromeTabs.TAB_ID_NONE */
		override val TAB_ID_NONE: Any? by ChromeTabs::TAB_ID_NONE

		/** @see ChromeTabs.TAB_INDEX_NONE */
		override val TAB_INDEX_NONE: Any? by ChromeTabs::TAB_INDEX_NONE

		/** @see ChromeTabs.onHighlighted */
		override val onHighlighted: Event<(highlightInfo: OnHighlightedInfo) -> Unit> by ChromeTabs::onHighlighted

		/** @see ChromeTabs.onRemoved */
		override val onRemoved: Event<(tabId: Int, removeInfo: OnRemovedInfo) -> Unit> by ChromeTabs::onRemoved

		/** @see ChromeTabs.onUpdated */
		override val onUpdated: Event<(tabId: Int, changeInfo: OnUpdatedInfo, tab: Tab) -> Unit> by ChromeTabs::onUpdated

		/** @see ChromeTabs.onAttached */
		override val onAttached: Event<(tabId: Int, attachInfo: OnAttachedInfo) -> Unit> by ChromeTabs::onAttached

		/** @see ChromeTabs.onMoved */
		override val onMoved: Event<(tabId: Int, moveInfo: OnMovedInfo) -> Unit> by ChromeTabs::onMoved

		/** @see ChromeTabs.onDetached */
		override val onDetached: Event<(tabId: Int, detachInfo: OnDetachedInfo) -> Unit> by ChromeTabs::onDetached

		/** @see ChromeTabs.onCreated */
		override val onCreated: Event<(tab: Tab) -> Unit> by ChromeTabs::onCreated

		/** @see ChromeTabs.onActivated */
		override val onActivated: Event<(activeInfo: OnActivatedInfo) -> Unit> by ChromeTabs::onActivated

		/** @see ChromeTabs.onReplaced */
		override val onReplaced: Event<(addedTabId: Int, removedTabId: Int) -> Unit> by ChromeTabs::onReplaced

		/** @see ChromeTabs.onSelectionChanged */
		override val onSelectionChanged: Event<(tabId: Int, selectInfo: OnSelectionChangedInfo) -> Unit> by ChromeTabs::onSelectionChanged

		/** @see ChromeTabs.onActiveChanged */
		override val onActiveChanged: Event<(tabId: Int, selectInfo: OnActiveChangedInfo) -> Unit> by ChromeTabs::onActiveChanged

		/** @see ChromeTabs.onHighlightChanged */
		override val onHighlightChanged: Event<(selectInfo: OnHighlightChangedInfo) -> Unit> by ChromeTabs::onHighlightChanged

		/** @see ChromeTabs.onZoomChange */
		override val onZoomChange: Event<(zoomChangeInfo: OnZoomChangeInfo) -> Unit> by ChromeTabs::onZoomChange

		/** @see ChromeTabs.executeScript */
		override suspend fun executeScript(tabId: Int?, details: InjectDetails): List<Any?>? = ChromeTabs.executeScript(tabId, details).await()?.asList()

		/** @see ChromeTabs.executeScript */
		override suspend fun executeScript(details: InjectDetails): List<Any?>? = ChromeTabs.executeScript(details).await()?.asList()

		/** @see ChromeTabs.get */
		override suspend fun get(tabId: Int): Tab = ChromeTabs.get(tabId).await()

		/** @see ChromeTabs.getAllInWindow */
		override suspend fun getAllInWindow(windowId: Int): List<Tab> = ChromeTabs.getAllInWindow(windowId).await().asList()

		/** @see ChromeTabs.getCurrent */
		override suspend fun getCurrent(): Tab? = ChromeTabs.getCurrent().await()

		/** @see ChromeTabs.getSelected */
		override suspend fun getSelected(windowId: Int): Tab = ChromeTabs.getSelected(windowId).await()

		/** @see ChromeTabs.getSelected */
		override suspend fun getSelected(): Tab = ChromeTabs.getSelected().await()

		/** @see ChromeTabs.create */
		override suspend fun create(createProperties: CreateProperties): Tab = ChromeTabs.create(createProperties).await()

		/** @see ChromeTabs.move */
		override suspend fun move(tabIds: List<Int>, moveProperties: MoveProperties): List<Tab> = ChromeTabs.move(tabIds.asJsReadonlyArrayView(), moveProperties).await().asList()

		/** @see ChromeTabs.move */
		override suspend fun move(tabId: Int, moveProperties: MoveProperties): Tab = ChromeTabs.move(tabId, moveProperties).await()

		/** @see ChromeTabs.update */
		override suspend fun update(tabId: Int, updateProperties: UpdateProperties): Tab? = ChromeTabs.update(tabId, updateProperties).await()

		/** @see ChromeTabs.update */
		override suspend fun update(updateProperties: UpdateProperties): Tab? = ChromeTabs.update(updateProperties).await()

		/** @see ChromeTabs.remove */
		override suspend fun remove(tabId: Int) = ChromeTabs.remove(tabId).await()

		/** @see ChromeTabs.remove */
		override suspend fun remove(tabIds: List<Int>) = ChromeTabs.remove(tabIds.asJsReadonlyArrayView()).await()

		/** @see ChromeTabs.captureVisibleTab */
		override suspend fun captureVisibleTab(): String = ChromeTabs.captureVisibleTab().await()

		/** @see ChromeTabs.captureVisibleTab */
		override suspend fun captureVisibleTab(windowId: Int): String = ChromeTabs.captureVisibleTab(windowId).await()

		/** @see ChromeTabs.captureVisibleTab */
		override suspend fun captureVisibleTab(options: ImageDetails): String = ChromeTabs.captureVisibleTab(options).await()

		/** @see ChromeTabs.captureVisibleTab */
		override suspend fun captureVisibleTab(windowId: Int, options: ImageDetails): String = ChromeTabs.captureVisibleTab(windowId, options).await()

		/** @see ChromeTabs.reload */
		override suspend fun reload() = ChromeTabs.reload().await()

		/** @see ChromeTabs.reload */
		override suspend fun reload(tabId: Int) = ChromeTabs.reload(tabId).await()

		/** @see ChromeTabs.reload */
		override suspend fun reload(reloadProperties: ReloadProperties) = ChromeTabs.reload(reloadProperties).await()

		/** @see ChromeTabs.reload */
		override suspend fun reload(tabId: Int, reloadProperties: ReloadProperties) = ChromeTabs.reload(tabId, reloadProperties).await()

		/** @see ChromeTabs.duplicate */
		override suspend fun duplicate(tabId: Int): Tab? = ChromeTabs.duplicate(tabId).await()

		/** @see ChromeTabs.sendMessage */
		override suspend fun <
			MESSAGE /* default is Any? */,
			RESPONSE /* default is Any? */
			>
			sendMessage(tabId: Int, message: MESSAGE, options: MessageSendOptions): RESPONSE = ChromeTabs.sendMessage<MESSAGE, RESPONSE>(tabId, message, options).await()

		/** @see ChromeTabs.sendMessage */
		override suspend fun <
			MESSAGE /* default is Any? */,
			RESPONSE /* default is Any? */
			>
			sendMessage(tabId: Int, message: MESSAGE): RESPONSE = ChromeTabs.sendMessage<MESSAGE, RESPONSE>(tabId, message).await()

		/** @see ChromeTabs.sendRequest */
		override suspend fun <
			Request /* default is Any? */,
			Response /* default is Any? */
			>
			sendRequest(tabId: Int, request: Request): Response = ChromeTabs.sendRequest<Request, Response>(tabId, request).await()

		/** @see ChromeTabs.connect */
		override fun connect(tabId: Int, connectInfo: ConnectInfo): Port = ChromeTabs.connect(tabId, connectInfo)

		/** @see ChromeTabs.connect */
		override fun connect(tabId: Int): Port = ChromeTabs.connect(tabId)

		/** @see ChromeTabs.insertCSS */
		override suspend fun insertCSS(details: InjectDetails) = ChromeTabs.insertCSS(details).await()

		/** @see ChromeTabs.insertCSS */
		override suspend fun insertCSS(tabId: Int, details: InjectDetails) = ChromeTabs.insertCSS(tabId, details).await()

		/** @see ChromeTabs.highlight */
		override suspend fun highlight(highlightInfo: HighlightInfo): Window = ChromeTabs.highlight(highlightInfo).await()

		/** @see ChromeTabs.query */
		override suspend fun query(queryInfo: QueryInfo): List<Tab> = ChromeTabs.query(queryInfo).await().asList()

		/** @see ChromeTabs.detectLanguage */
		override suspend fun detectLanguage(): String = ChromeTabs.detectLanguage().await()

		/** @see ChromeTabs.detectLanguage */
		override suspend fun detectLanguage(tabId: Int): String = ChromeTabs.detectLanguage(tabId).await()

		/** @see ChromeTabs.setZoom */
		override suspend fun setZoom(zoomFactor: Double) = ChromeTabs.setZoom(zoomFactor).await()

		/** @see ChromeTabs.setZoom */
		override suspend fun setZoom(tabId: Int, zoomFactor: Double) = ChromeTabs.setZoom(tabId, zoomFactor).await()

		/** @see ChromeTabs.getZoom */
		override suspend fun getZoom(): Double = ChromeTabs.getZoom().await()

		/** @see ChromeTabs.getZoom */
		override suspend fun getZoom(tabId: Int): Double = ChromeTabs.getZoom(tabId).await()

		/** @see ChromeTabs.setZoomSettings */
		override suspend fun setZoomSettings(zoomSettings: ZoomSettings) = ChromeTabs.setZoomSettings(zoomSettings).await()

		/** @see ChromeTabs.setZoomSettings */
		override suspend fun setZoomSettings(tabId: Int?, zoomSettings: ZoomSettings) = ChromeTabs.setZoomSettings(zoomSettings).await()

		/** @see ChromeTabs.getZoomSettings */
		override suspend fun getZoomSettings(): ZoomSettings = ChromeTabs.getZoomSettings().await()

		/** @see ChromeTabs.getZoomSettings */
		override suspend fun getZoomSettings(tabId: Int): ZoomSettings = ChromeTabs.getZoomSettings(tabId).await()

		/** @see ChromeTabs.discard */
		override suspend fun discard(): Tab? = ChromeTabs.discard().await()

		/** @see ChromeTabs.discard */
		override suspend fun discard(tabId: Int): Tab? = ChromeTabs.discard(tabId).await()

		/** @see ChromeTabs.goForward */
		override suspend fun goForward() = ChromeTabs.goForward().await()

		/** @see ChromeTabs.goForward */
		override suspend fun goForward(tabId: Int) = ChromeTabs.goForward(tabId).await()

		/** @see ChromeTabs.goBack */
		override suspend fun goBack() = ChromeTabs.goBack().await()

		/** @see ChromeTabs.goBack */
		override suspend fun goBack(tabId: Int) = ChromeTabs.goBack(tabId).await()

		/** @see ChromeTabs.group */
		override suspend fun group(options: GroupOptions): Int = ChromeTabs.group(options).await()

		/** @see ChromeTabs.ungroup */
		override suspend fun ungroup(tabIds: Int) = ChromeTabs.ungroup(tabIds).await()

		/** @see ChromeTabs.ungroup */
		override suspend fun ungroup(tabIds: IntArray) = ChromeTabs.ungroup(tabIds).await()
	}

	/** @see ChromeTabs.MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND */
	val MAX_CAPTURE_VISIBLE_TAB_CALLS_PER_SECOND: Any?

	/** @see ChromeTabs.TAB_ID_NONE */
	val TAB_ID_NONE: Any?

	/** @see ChromeTabs.TAB_INDEX_NONE */
	val TAB_INDEX_NONE: Any?

	/** @see ChromeTabs.onHighlighted */
	val onHighlighted: Event<(highlightInfo: OnHighlightedInfo) -> Unit>

	/** @see ChromeTabs.onRemoved */
	val onRemoved: Event<(tabId: Int, removeInfo: OnRemovedInfo) -> Unit>

	/** @see ChromeTabs.onUpdated */
	val onUpdated: Event<(tabId: Int, changeInfo: OnUpdatedInfo, tab: Tab) -> Unit>

	/** @see ChromeTabs.onAttached */
	val onAttached: Event<(tabId: Int, attachInfo: OnAttachedInfo) -> Unit>

	/** @see ChromeTabs.onMoved */
	val onMoved: Event<(tabId: Int, moveInfo: OnMovedInfo) -> Unit>

	/** @see ChromeTabs.onDetached */
	val onDetached: Event<(tabId: Int, detachInfo: OnDetachedInfo) -> Unit>

	/** @see ChromeTabs.onCreated */
	val onCreated: Event<(tab: Tab) -> Unit>

	/** @see ChromeTabs.onActivated */
	val onActivated: Event<(activeInfo: OnActivatedInfo) -> Unit>

	/** @see ChromeTabs.onReplaced */
	val onReplaced: Event<(addedTabId: Int, removedTabId: Int) -> Unit>

	/** @see ChromeTabs.onSelectionChanged */
	val onSelectionChanged: Event<(tabId: Int, selectInfo: OnSelectionChangedInfo) -> Unit>

	/** @see ChromeTabs.onActiveChanged */
	val onActiveChanged: Event<(tabId: Int, selectInfo: OnActiveChangedInfo) -> Unit>

	/** @see ChromeTabs.onHighlightChanged */
	val onHighlightChanged: Event<(selectInfo: OnHighlightChangedInfo) -> Unit>

	/** @see ChromeTabs.onZoomChange */
	val onZoomChange: Event<(zoomChangeInfo: OnZoomChangeInfo) -> Unit>

	/** @see ChromeTabs.executeScript */
	suspend fun executeScript(tabId: Int?, details: InjectDetails): List<Any?>?

	/** @see ChromeTabs.executeScript */
	suspend fun executeScript(details: InjectDetails): List<Any?>?

	/** @see ChromeTabs.get */
	suspend fun get(tabId: Int): Tab

	/** @see ChromeTabs.getAllInWindow */
	suspend fun getAllInWindow(windowId: Int): List<Tab>

	/** @see ChromeTabs.getCurrent */
	suspend fun getCurrent(): Tab?

	/** @see ChromeTabs.getSelected */
	suspend fun getSelected(windowId: Int): Tab

	/** @see ChromeTabs.getSelected */
	suspend fun getSelected(): Tab

	/** @see ChromeTabs.create */
	suspend fun create(createProperties: CreateProperties): Tab

	/** @see ChromeTabs.move */
	suspend fun move(tabIds: List<Int>, moveProperties: MoveProperties): List<Tab>

	/** @see ChromeTabs.move */
	suspend fun move(tabId: Int, moveProperties: MoveProperties): Tab

	/** @see ChromeTabs.update */
	suspend fun update(tabId: Int, updateProperties: UpdateProperties): Tab?

	/** @see ChromeTabs.update */
	suspend fun update(updateProperties: UpdateProperties): Tab?

	/** @see ChromeTabs.remove */
	suspend fun remove(tabId: Int)

	/** @see ChromeTabs.remove */
	suspend fun remove(tabIds: List<Int>)

	/** @see ChromeTabs.captureVisibleTab */
	suspend fun captureVisibleTab(): String

	/** @see ChromeTabs.captureVisibleTab */
	suspend fun captureVisibleTab(windowId: Int): String

	/** @see ChromeTabs.captureVisibleTab */
	suspend fun captureVisibleTab(options: ImageDetails): String

	/** @see ChromeTabs.captureVisibleTab */
	suspend fun captureVisibleTab(windowId: Int, options: ImageDetails): String

	/** @see ChromeTabs.reload */
	suspend fun reload()

	/** @see ChromeTabs.reload */
	suspend fun reload(tabId: Int)

	/** @see ChromeTabs.reload */
	suspend fun reload(reloadProperties: ReloadProperties)

	/** @see ChromeTabs.reload */
	suspend fun reload(tabId: Int, reloadProperties: ReloadProperties)

	/** @see ChromeTabs.duplicate */
	suspend fun duplicate(tabId: Int): Tab?

	/** @see ChromeTabs.sendMessage */
	suspend fun <
		MESSAGE /* default is Any? */,
		RESPONSE /* default is Any? */
		>
		sendMessage(tabId: Int, message: MESSAGE, options: MessageSendOptions): RESPONSE

	/** @see ChromeTabs.sendMessage */
	suspend fun <
		MESSAGE /* default is Any? */,
		RESPONSE /* default is Any? */
		>
		sendMessage(tabId: Int, message: MESSAGE): RESPONSE

	/** @see ChromeTabs.sendRequest */
	suspend fun <
		Request /* default is Any? */,
		Response /* default is Any? */
		>
		sendRequest(tabId: Int, request: Request): Response

	/** @see ChromeTabs.connect */
	fun connect(tabId: Int, connectInfo: ConnectInfo): Port

	/** @see ChromeTabs.connect */
	fun connect(tabId: Int): Port

	/** @see ChromeTabs.insertCSS */
	suspend fun insertCSS(details: InjectDetails)

	/** @see ChromeTabs.insertCSS */
	suspend fun insertCSS(tabId: Int, details: InjectDetails)

	/** @see ChromeTabs.highlight */
	suspend fun highlight(highlightInfo: HighlightInfo): Window

	/** @see ChromeTabs.query */
	suspend fun query(queryInfo: QueryInfo): List<Tab>

	/** @see ChromeTabs.detectLanguage */
	suspend fun detectLanguage(): String

	/** @see ChromeTabs.detectLanguage */
	suspend fun detectLanguage(tabId: Int): String

	/** @see ChromeTabs.setZoom */
	suspend fun setZoom(zoomFactor: Double)

	/** @see ChromeTabs.setZoom */
	suspend fun setZoom(tabId: Int, zoomFactor: Double)

	/** @see ChromeTabs.getZoom */
	suspend fun getZoom(): Double

	/** @see ChromeTabs.getZoom */
	suspend fun getZoom(tabId: Int): Double

	/** @see ChromeTabs.setZoomSettings */
	suspend fun setZoomSettings(zoomSettings: ZoomSettings)

	/** @see ChromeTabs.setZoomSettings */
	suspend fun setZoomSettings(tabId: Int?, zoomSettings: ZoomSettings)

	/** @see ChromeTabs.getZoomSettings */
	suspend fun getZoomSettings(): ZoomSettings

	/** @see ChromeTabs.getZoomSettings */
	suspend fun getZoomSettings(tabId: Int): ZoomSettings

	/** @see ChromeTabs.discard */
	suspend fun discard(): Tab?

	/** @see ChromeTabs.discard */
	suspend fun discard(tabId: Int): Tab?

	/** @see ChromeTabs.goForward */
	suspend fun goForward()

	/** @see ChromeTabs.goForward */
	suspend fun goForward(tabId: Int)

	/** @see ChromeTabs.goBack */
	suspend fun goBack()

	/** @see ChromeTabs.goBack */
	suspend fun goBack(tabId: Int)

	/** @see ChromeTabs.group */
	suspend fun group(options: GroupOptions): Int

	/** @see ChromeTabs.ungroup */
	suspend fun ungroup(tabIds: Int)

	/** @see ChromeTabs.ungroup */
	suspend fun ungroup(tabIds: IntArray)
}