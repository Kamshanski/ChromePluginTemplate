package dev.kamshanski.chrome.component.chrome.extension

import chrome.extension.FetchProperties
import org.w3c.dom.Window

/**
 * @see chrome.extension.ChromeExtension.getViews
 * @see FetchProperties
 */
fun KChromeExtension.getViews(
	tabId: Int? = null,
	windowId: Int? = null,
	type: String? = null,
): List<Window> =
	getViews(
		FetchProperties(
			tabId = tabId,
			windowId = windowId,
			type = type,
		)
	)