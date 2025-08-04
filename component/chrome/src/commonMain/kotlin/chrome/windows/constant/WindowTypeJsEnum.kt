@file:JsQualifier("chrome.windows")

package chrome.windows.constant

import chrome.windows.WindowType

@JsName("WindowType")
internal external object WindowTypeJsEnum {

	val NORMAL: WindowType
	val POPUP: WindowType
	val PANEL: WindowType
	val APP: WindowType
	val DEVTOOLS: WindowType
}