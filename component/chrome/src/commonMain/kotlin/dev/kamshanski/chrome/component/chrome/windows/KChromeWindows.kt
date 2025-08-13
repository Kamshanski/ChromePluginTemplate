package dev.kamshanski.chrome.component.chrome.windows

import chrome.events.Event
import chrome.windows.ChromeWindows
import chrome.windows.CreateData
import chrome.windows.QueryOptions
import chrome.windows.UpdateInfo
import chrome.windows.Window
import chrome.windows.WindowsEvent
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await

@Suppress("unused")
interface KChromeWindows {

	companion object : KChromeWindows {

		override val WINDOW_ID_CURRENT: Int by ChromeWindows::WINDOW_ID_CURRENT

		override val WINDOW_ID_NONE: Int by ChromeWindows::WINDOW_ID_NONE

		override val onRemoved: WindowsEvent<(windowId: Int) -> Unit> by ChromeWindows::onRemoved

		override val onCreated: WindowsEvent<(window: Window) -> Unit> by ChromeWindows::onCreated

		override val onFocusChanged: WindowsEvent<(windowId: Int) -> Unit> by ChromeWindows::onFocusChanged

		override val onBoundsChanged: Event<(window: Window) -> Unit> by ChromeWindows::onBoundsChanged

		override suspend fun get(windowId: Int): Window = ChromeWindows.get(windowId).await()
		override suspend fun get(windowId: Int, queryOptions: QueryOptions): Window = ChromeWindows.get(windowId, queryOptions).await()

		override suspend fun getCurrent(): Window = ChromeWindows.getCurrent().await()
		override suspend fun getCurrent(queryOptions: QueryOptions): Window = ChromeWindows.getCurrent(queryOptions).await()

		override suspend fun create(): Window? = ChromeWindows.create().await()
		override suspend fun create(createData: CreateData): Window? = ChromeWindows.create(createData).await()

		override suspend fun getAll(): List<Window> = ChromeWindows.getAll().await().asList()
		override suspend fun getAll(queryOptions: QueryOptions): List<Window> = ChromeWindows.getAll(queryOptions).await().asList()

		override suspend fun update(windowId: Int, updateInfo: UpdateInfo): Window = ChromeWindows.update(windowId, updateInfo).await()

		override suspend fun remove(windowId: Int) = ChromeWindows.remove(windowId).await()

		override suspend fun getLastFocused(): Window = ChromeWindows.getLastFocused().await()
		override suspend fun getLastFocused(queryOptions: QueryOptions): Window = ChromeWindows.getLastFocused(queryOptions).await()
	}

	val WINDOW_ID_CURRENT: Int

	val WINDOW_ID_NONE: Int

	val onRemoved: WindowsEvent<(windowId: Int) -> Unit>

	val onCreated: WindowsEvent<(window: Window) -> Unit>

	val onFocusChanged: WindowsEvent<(windowId: Int) -> Unit>

	val onBoundsChanged: Event<(window: Window) -> Unit>

	suspend fun get(windowId: Int): Window
	suspend fun get(windowId: Int, queryOptions: QueryOptions): Window

	suspend fun getCurrent(): Window
	suspend fun getCurrent(queryOptions: QueryOptions): Window

	suspend fun create(): Window?
	suspend fun create(createData: CreateData): Window?

	suspend fun getAll(): List<Window>
	suspend fun getAll(queryOptions: QueryOptions): List<Window>

	suspend fun update(windowId: Int, updateInfo: UpdateInfo): Window

	suspend fun remove(windowId: Int)

	suspend fun getLastFocused(): Window
	suspend fun getLastFocused(queryOptions: QueryOptions): Window
}