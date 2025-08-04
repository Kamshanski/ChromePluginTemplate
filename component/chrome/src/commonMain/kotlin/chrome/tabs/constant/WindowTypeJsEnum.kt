@file:JsQualifier("chrome.tabs")

package chrome.tabs.constant

import chrome.tabs.WindowType

@JsName("WindowType")
internal external object WindowTypeJsEnum {
	val NORMAL: WindowType
	val POPUP: WindowType
	val PANEL: WindowType
	val APP: WindowType
	val DEVTOOLS: WindowType
}