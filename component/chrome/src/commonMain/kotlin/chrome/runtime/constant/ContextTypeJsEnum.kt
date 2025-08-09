@file:JsQualifier("chrome.runtime")

package chrome.runtime.constant

import chrome.runtime.ContextType

@JsName("ContextType")
internal external object ContextTypeJsEnum {

	val TAB: ContextType
	val POPUP: ContextType
	val BACKGROUND: ContextType
	val OFFSCREEN_DOCUMENT: ContextType
	val SIDE_PANEL: ContextType
	val DEVELOPER_TOOLS: ContextType
}