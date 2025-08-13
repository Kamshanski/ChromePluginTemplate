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

/** @see ChromeWindows */
interface KChromeWindows {

	companion object : KChromeWindows {

		/** @see ChromeWindows.WINDOW_ID_CURRENT */
		override val WINDOW_ID_CURRENT: Int by ChromeWindows::WINDOW_ID_CURRENT

		/** @see ChromeWindows.WINDOW_ID_NONE */
		override val WINDOW_ID_NONE: Int by ChromeWindows::WINDOW_ID_NONE

		/** @see ChromeWindows.onRemoved */
		override val onRemoved: WindowsEvent<(windowId: Int) -> Unit> by ChromeWindows::onRemoved

		/** @see ChromeWindows.onCreated */
		override val onCreated: WindowsEvent<(window: Window) -> Unit> by ChromeWindows::onCreated

		/** @see ChromeWindows.onFocusChanged */
		override val onFocusChanged: WindowsEvent<(windowId: Int) -> Unit> by ChromeWindows::onFocusChanged

		/** @see ChromeWindows.onBoundsChanged */
		override val onBoundsChanged: Event<(window: Window) -> Unit> by ChromeWindows::onBoundsChanged

		/** @see ChromeWindows.get */
		override suspend fun get(windowId: Int): Window = ChromeWindows.get(windowId).await()

		/** @see ChromeWindows.get */
		override suspend fun get(windowId: Int, queryOptions: QueryOptions): Window = ChromeWindows.get(windowId, queryOptions).await()

		/** @see ChromeWindows.getCurrent */
		override suspend fun getCurrent(): Window = ChromeWindows.getCurrent().await()

		/** @see ChromeWindows.getCurrent */
		override suspend fun getCurrent(queryOptions: QueryOptions): Window = ChromeWindows.getCurrent(queryOptions).await()

		/** @see ChromeWindows.create */
		override suspend fun create(): Window? = ChromeWindows.create().await()

		/** @see ChromeWindows.create */
		override suspend fun create(createData: CreateData): Window? = ChromeWindows.create(createData).await()

		/** @see ChromeWindows.getAll */
		override suspend fun getAll(): List<Window> = ChromeWindows.getAll().await().asList()

		/** @see ChromeWindows.getAll */
		override suspend fun getAll(queryOptions: QueryOptions): List<Window> = ChromeWindows.getAll(queryOptions).await().asList()

		/** @see ChromeWindows.update */
		override suspend fun update(windowId: Int, updateInfo: UpdateInfo): Window = ChromeWindows.update(windowId, updateInfo).await()

		/** @see ChromeWindows.remove */
		override suspend fun remove(windowId: Int) = ChromeWindows.remove(windowId).await()

		/** @see ChromeWindows.getLastFocused */
		override suspend fun getLastFocused(): Window = ChromeWindows.getLastFocused().await()

		/** @see ChromeWindows.getLastFocused */
		override suspend fun getLastFocused(queryOptions: QueryOptions): Window = ChromeWindows.getLastFocused(queryOptions).await()
	}

	/** @see ChromeWindows.WINDOW_ID_CURRENT */
	val WINDOW_ID_CURRENT: Int

	/** @see ChromeWindows.WINDOW_ID_NONE */
	val WINDOW_ID_NONE: Int

	/** @see ChromeWindows.onRemoved */
	val onRemoved: WindowsEvent<(windowId: Int) -> Unit>

	/** @see ChromeWindows.onCreated */
	val onCreated: WindowsEvent<(window: Window) -> Unit>

	/** @see ChromeWindows.onFocusChanged */
	val onFocusChanged: WindowsEvent<(windowId: Int) -> Unit>

	/** @see ChromeWindows.onBoundsChanged */
	val onBoundsChanged: Event<(window: Window) -> Unit>

	/** @see ChromeWindows.get */
	suspend fun get(windowId: Int): Window

	/** @see ChromeWindows.get */
	suspend fun get(windowId: Int, queryOptions: QueryOptions): Window

	/** @see ChromeWindows.getCurrent */
	suspend fun getCurrent(): Window

	/** @see ChromeWindows.getCurrent */
	suspend fun getCurrent(queryOptions: QueryOptions): Window

	/** @see ChromeWindows.create */
	suspend fun create(): Window?

	/** @see ChromeWindows.create */
	suspend fun create(createData: CreateData): Window?

	/** @see ChromeWindows.getAll */
	suspend fun getAll(): List<Window>

	/** @see ChromeWindows.getAll */
	suspend fun getAll(queryOptions: QueryOptions): List<Window>

	/** @see ChromeWindows.update */
	suspend fun update(windowId: Int, updateInfo: UpdateInfo): Window

	/** @see ChromeWindows.remove */
	suspend fun remove(windowId: Int)

	/** @see ChromeWindows.getLastFocused */
	suspend fun getLastFocused(): Window

	/** @see ChromeWindows.getLastFocused */
	suspend fun getLastFocused(queryOptions: QueryOptions): Window
}