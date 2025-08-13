package dev.kamshanski.chrome.component.chrome.windows

import chrome.windows.CreateData
import chrome.windows.QueryOptions
import chrome.windows.UpdateInfo
import chrome.windows.Window
import chrome.windows.WindowTypeEnum

/**
 * @see chrome.windows.ChromeWindows.get
 * @see QueryOptions
 */
suspend fun KChromeWindows.get(
	windowId: Int,
	populate: Boolean? = null,
	windowTypes: List<WindowTypeEnum>? = null,
): Window = get(
	windowId = windowId,
	queryOptions = QueryOptions(
		populate = populate,
		windowTypes = windowTypes,
	),
)

/**
 * @see chrome.windows.ChromeWindows.getCurrent
 * @see QueryOptions
 */
suspend fun KChromeWindows.getCurrent(
	populate: Boolean? = null,
	windowTypes: List<WindowTypeEnum>? = null,
): Window = getCurrent(
	queryOptions = QueryOptions(
		populate = populate,
		windowTypes = windowTypes,
	),
)

/**
 * @see chrome.windows.ChromeWindows.create
 * @see CreateData
 */
suspend fun KChromeWindows.create(
	tabId: Int? = null,
	url: Any? = null,
	top: Int? = null,
	height: Int? = null,
	width: Int? = null,
	focused: Boolean? = null,
	incognito: Boolean? = null,
	type: String? = null,
	left: Int? = null,
	state: String? = null,
	setSelfAsOpener: Boolean? = null,
): Window? = create(
	CreateData(
		tabId = tabId,
		url = url,
		top = top,
		height = height,
		width = width,
		focused = focused,
		incognito = incognito,
		type = type,
		left = left,
		state = state,
		setSelfAsOpener = setSelfAsOpener,
	)
)

/**
 * @see chrome.windows.ChromeWindows.getAll
 * @see QueryOptions
 */
suspend fun KChromeWindows.getAll(
	populate: Boolean? = null,
	windowTypes: List<WindowTypeEnum>? = null,
): List<Window> = getAll(
	QueryOptions(
		populate = populate,
		windowTypes = windowTypes,
	)
)

/**
 * @see chrome.windows.ChromeWindows.update
 * @see UpdateInfo
 */
suspend fun KChromeWindows.update(
	windowId: Int,
	top: Int? = null,
	drawAttention: Boolean? = null,
	height: Int? = null,
	width: Int? = null,
	state: String? = null,
	focused: Boolean? = null,
	left: Int? = null,
): Window = update(
	windowId,
	UpdateInfo(
		top = top,
		drawAttention = drawAttention,
		height = height,
		width = width,
		state = state,
		focused = focused,
		left = left,
	)
)

/**
 * @see chrome.windows.ChromeWindows.getLastFocused
 * @see QueryOptions
 */
suspend fun KChromeWindows.getLastFocused(
	populate: Boolean? = null,
	windowTypes: List<WindowTypeEnum>? = null,
): Window =
	getLastFocused(
		queryOptions = QueryOptions(
			populate = populate,
			windowTypes = windowTypes,
		),
	)