package dev.kamshanski.chrome.component.chrome.tabs

import chrome.extensiontypes.CSSOrigin
import chrome.extensiontypes.ImageDetails
import chrome.extensiontypes.ImageFormat
import chrome.extensiontypes.InjectDetails
import chrome.extensiontypes.RunAt
import chrome.runtime.Port
import chrome.tabs.ConnectInfo
import chrome.tabs.CreateProperties
import chrome.tabs.GroupCreateProperties
import chrome.tabs.GroupOptions
import chrome.tabs.HighlightInfo
import chrome.tabs.MessageSendOptions
import chrome.tabs.MoveProperties
import chrome.tabs.QueryInfo
import chrome.tabs.ReloadProperties
import chrome.tabs.Tab
import chrome.tabs.TabStatus
import chrome.tabs.UpdateProperties
import chrome.tabs.WindowType
import chrome.tabs.ZoomSettings
import chrome.tabs.ZoomSettingsMode
import chrome.tabs.ZoomSettingsModeEnum
import chrome.tabs.ZoomSettingsScope
import chrome.windows.Window

/**
 * @see chrome.tabs.ChromeTabs.executeScript
 * @see InjectDetails
 */
suspend fun KChromeTabs.executeScript(
	tabId: Int?,
	allFrames: Boolean? = null,
	code: String? = null,
	cssOrigin: CSSOrigin? = null,
	file: String? = null,
	frameId: Int? = null,
	matchAboutBlank: Boolean? = null,
	runAt: RunAt? = null,
): List<Any?>? = executeScript(
	tabId = tabId,
	details = InjectDetails(
		allFrames = allFrames,
		code = code,
		cssOrigin = cssOrigin,
		file = file,
		frameId = frameId,
		matchAboutBlank = matchAboutBlank,
		runAt = runAt,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.executeScript
 * @see InjectDetails
 */
suspend fun KChromeTabs.executeScript(
	tabId: Int?,
	allFrames: Boolean? = null,
	cssOrigin: CSSOrigin? = null,
	file: String? = null,
	frameId: Int? = null,
	matchAboutBlank: Boolean? = null,
	runAt: RunAt? = null,
): List<Any?>? = executeScript(
	tabId = tabId,
	details = InjectDetails(
		allFrames = allFrames,
		cssOrigin = cssOrigin,
		file = file,
		frameId = frameId,
		matchAboutBlank = matchAboutBlank,
		runAt = runAt,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.executeScript
 * @see InjectDetails
 */
suspend fun KChromeTabs.executeScript(
	allFrames: Boolean? = null,
	code: String? = null,
	cssOrigin: CSSOrigin? = null,
	file: String? = null,
	frameId: Int? = null,
	matchAboutBlank: Boolean? = null,
	runAt: RunAt? = null,
): List<Any?>? = executeScript(
	details = InjectDetails(
		allFrames = allFrames,
		code = code,
		cssOrigin = cssOrigin,
		file = file,
		frameId = frameId,
		matchAboutBlank = matchAboutBlank,
		runAt = runAt,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.executeScript
 * @see InjectDetails
 */
suspend fun KChromeTabs.executeScript(
	allFrames: Boolean? = null,
	cssOrigin: CSSOrigin? = null,
	file: String? = null,
	frameId: Int? = null,
	matchAboutBlank: Boolean? = null,
	runAt: RunAt? = null,
): List<Any?>? = executeScript(
	details = InjectDetails(
		allFrames = allFrames,
		cssOrigin = cssOrigin,
		file = file,
		frameId = frameId,
		matchAboutBlank = matchAboutBlank,
		runAt = runAt,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.create
 * @see CreateProperties
 */
suspend fun KChromeTabs.create(
	index: Int? = null,
	openerTabId: Int? = null,
	url: String? = null,
	pinned: Boolean? = false,
	windowId: Int? = null,
	active: Boolean? = true,
	selected: Boolean? = true,
): Tab = create(
	CreateProperties(
		index = index,
		openerTabId = openerTabId,
		url = url,
		pinned = pinned,
		windowId = windowId,
		active = active,
		selected = selected,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.move
 * @see MoveProperties
 */
suspend fun KChromeTabs.move(
	tabIds: List<Int>,
	index: Int,
	windowId: Int? = null,
): List<Tab> = move(
	tabIds = tabIds,
	moveProperties = MoveProperties(
		index = index,
		windowId = windowId,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.move
 * @see MoveProperties
 */
suspend fun KChromeTabs.move(
	tabId: Int,
	index: Int,
	windowId: Int? = null,
): Tab = move(
	tabId = tabId,
	moveProperties = MoveProperties(
		index = index,
		windowId = windowId,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.update
 * @see UpdateProperties
 */
suspend fun KChromeTabs.update(
	tabId: Int,
	pinned: Boolean? = null,
	openerTabId: Int? = null,
	url: String? = null,
	highlighted: Boolean? = null,
	active: Boolean? = null,
	selected: Boolean? = null,
	muted: Boolean? = null,
	autoDiscardable: Boolean? = null,
): Tab? = update(
	tabId = tabId,
	updateProperties = UpdateProperties(
		pinned = pinned,
		openerTabId = openerTabId,
		url = url,
		highlighted = highlighted,
		active = active,
		selected = selected,
		muted = muted,
		autoDiscardable = autoDiscardable,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.update
 * @see UpdateProperties
 */
suspend fun KChromeTabs.update(
	pinned: Boolean? = null,
	openerTabId: Int? = null,
	url: String? = null,
	highlighted: Boolean? = null,
	active: Boolean? = null,
	selected: Boolean? = null,
	muted: Boolean? = null,
	autoDiscardable: Boolean? = null,
): Tab? = update(
	updateProperties = UpdateProperties(
		pinned = pinned,
		openerTabId = openerTabId,
		url = url,
		highlighted = highlighted,
		active = active,
		selected = selected,
		muted = muted,
		autoDiscardable = autoDiscardable,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.captureVisibleTab
 * @see ImageDetails
 */
suspend fun KChromeTabs.captureVisibleTab(
	format: ImageFormat? = null,
	quality: Double? = null,
): String = captureVisibleTab(
	options = ImageDetails(
		format = format,
		quality = quality,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.captureVisibleTab
 * @see ImageDetails
 */
suspend fun KChromeTabs.captureVisibleTab(
	windowId: Int,
	format: ImageFormat? = null,
	quality: Double? = null,
): String = captureVisibleTab(
	windowId = windowId,
	options = ImageDetails(
		format = format,
		quality = quality,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.reload
 * @see ReloadProperties
 */
suspend fun KChromeTabs.reload(
	bypassCache: Boolean? = false,
) = reload(
	reloadProperties = ReloadProperties(
		bypassCache = bypassCache
	),
)

/**
 * @see chrome.tabs.ChromeTabs.reload
 * @see ReloadProperties
 */
suspend fun KChromeTabs.reload(
	tabId: Int,
	bypassCache: Boolean? = false,
) = reload(
	tabId = tabId,
	reloadProperties = ReloadProperties(
		bypassCache = bypassCache
	),
)

/**
 * @see chrome.tabs.ChromeTabs.sendMessage
 * @see MessageSendOptions
 */
suspend fun <
	MESSAGE /* default is Any? */,
	RESPONSE /* default is Any? */
	>
	KChromeTabs.sendMessage(
	tabId: Int,
	message: MESSAGE,
	frameId: Int? = null,
	documentId: Int? = null,
): RESPONSE = sendMessage<MESSAGE, RESPONSE>(
	tabId = tabId,
	message = message,
	options = MessageSendOptions(
		frameId = frameId,
		documentId = documentId,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.connect
 * @see ConnectInfo
 */
fun KChromeTabs.connect(
	tabId: Int,
	name: String? = null,
	frameId: Int? = null,
	documentId: String? = null,
): Port = connect(
	tabId = tabId,
	connectInfo = ConnectInfo(
		name = name,
		frameId = frameId,
		documentId = documentId,
	),
)

/**
 * @see chrome.tabs.ChromeTabs.insertCSS
 * @see InjectDetails
 */
suspend fun KChromeTabs.insertCSS(
	tabId: Int,
	allFrames: Boolean? = null,
	code: String? = null,
	cssOrigin: CSSOrigin? = null,
	file: String? = null,
	frameId: Int? = null,
	matchAboutBlank: Boolean? = null,
	runAt: RunAt? = null,
) = insertCSS(
	tabId = tabId,
	details = InjectDetails(
		allFrames = allFrames,
		code = code,
		cssOrigin = cssOrigin,
		file = file,
		frameId = frameId,
		matchAboutBlank = matchAboutBlank,
		runAt = runAt,
	)
)


/**
 * @see chrome.tabs.ChromeTabs.insertCSS
 * @see InjectDetails
 */
suspend fun KChromeTabs.insertCSS(
	tabId: Int,
	allFrames: Boolean? = null,
	cssOrigin: CSSOrigin? = null,
	file: String? = null,
	frameId: Int? = null,
	matchAboutBlank: Boolean? = null,
	runAt: RunAt? = null,
) = insertCSS(
	tabId = tabId,
	details = InjectDetails(
		allFrames = allFrames,
		cssOrigin = cssOrigin,
		file = file,
		frameId = frameId,
		matchAboutBlank = matchAboutBlank,
		runAt = runAt,
	)
)


/**
 * @see chrome.tabs.ChromeTabs.insertCSS
 * @see InjectDetails
 */
suspend fun KChromeTabs.insertCSS(
	allFrames: Boolean? = null,
	code: String? = null,
	cssOrigin: CSSOrigin? = null,
	file: String? = null,
	frameId: Int? = null,
	matchAboutBlank: Boolean? = null,
	runAt: RunAt? = null,
) = insertCSS(
	details = InjectDetails(
		allFrames = allFrames,
		code = code,
		cssOrigin = cssOrigin,
		file = file,
		frameId = frameId,
		matchAboutBlank = matchAboutBlank,
		runAt = runAt,
	)
)


/**
 * @see chrome.tabs.ChromeTabs.insertCSS
 * @see InjectDetails
 */
suspend fun KChromeTabs.insertCSS(
	allFrames: Boolean? = null,
	cssOrigin: CSSOrigin? = null,
	file: String? = null,
	frameId: Int? = null,
	matchAboutBlank: Boolean? = null,
	runAt: RunAt? = null,
) = insertCSS(
	details = InjectDetails(
		allFrames = allFrames,
		cssOrigin = cssOrigin,
		file = file,
		frameId = frameId,
		matchAboutBlank = matchAboutBlank,
		runAt = runAt,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.highlight
 * @see HighlightInfo
 */
suspend fun KChromeTabs.highlight(
	tabs: List<Int>,
	windowId: Int? = null,
): Window = highlight(
	highlightInfo = HighlightInfo(
		tabs = tabs,
		windowId = windowId,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.query
 * @see QueryInfo
 */
suspend fun KChromeTabs.query(
	status: TabStatus? = null,
	lastFocusedWindow: Boolean? = null,
	windowId: Int? = null,
	windowType: WindowType? = null,
	active: Boolean? = null,
	index: Int? = null,
	title: String? = null,
	url: List<String>,
	currentWindow: Boolean? = null,
	highlighted: Boolean? = null,
	discarded: Boolean? = null,
	frozen: Boolean? = null,
	autoDiscardable: Boolean? = null,
	pinned: Boolean? = null,
	audible: Boolean? = null,
	muted: Boolean? = null,
	groupId: Int? = null,
): List<Tab> = query(
	queryInfo = QueryInfo(
		status = status,
		lastFocusedWindow = lastFocusedWindow,
		windowId = windowId,
		windowType = windowType,
		active = active,
		index = index,
		title = title,
		url = url,
		currentWindow = currentWindow,
		highlighted = highlighted,
		discarded = discarded,
		frozen = frozen,
		autoDiscardable = autoDiscardable,
		pinned = pinned,
		audible = audible,
		muted = muted,
		groupId = groupId,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.executsetZoomSettingseScript
 * @see ZoomSettings
 */
suspend fun KChromeTabs.setZoomSettings(
	mode: ZoomSettingsMode = ZoomSettingsModeEnum.AUTOMATIC.value,
	scope: ZoomSettingsScope? = null,
	defaultZoomFactor: Double? = null,
) = setZoomSettings(
	zoomSettings = ZoomSettings(
		mode = mode,
		scope = scope,
		defaultZoomFactor = defaultZoomFactor,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.executsetZoomSettingseScript
 * @see ZoomSettings
 */
suspend fun KChromeTabs.setZoomSettings(
	tabId: Int?,
	mode: ZoomSettingsMode = ZoomSettingsModeEnum.AUTOMATIC.value,
	scope: ZoomSettingsScope? = null,
	defaultZoomFactor: Double? = null,
) = setZoomSettings(
	tabId = tabId,
	zoomSettings = ZoomSettings(
		mode = mode,
		scope = scope,
		defaultZoomFactor = defaultZoomFactor,
	)
)

/**
 * @see chrome.tabs.ChromeTabs.group
 * @see GroupOptions
 */
suspend fun KChromeTabs.group(
	createProperties: GroupCreateProperties? = null,
	groupId: Int? = null,
	tabIds: List<Int>,
): Int = group(
	options = GroupOptions(
		createProperties = createProperties,
		groupId = groupId,
		tabIds = tabIds,
	)
)
