@file:JsQualifier("chrome.windows")

package chrome.windows.constant

import chrome.windows.WindowState

@JsName("WindowState")
internal external object WindowStateJsEnum {

	val NORMAL: WindowState
	val MINIMIZED: WindowState
	val MAXIMIZED: WindowState
	val FULLSCREEN: WindowState
	val LOCKED_FULLSCREEN: WindowState
}