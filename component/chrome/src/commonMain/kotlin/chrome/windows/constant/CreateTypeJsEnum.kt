@file:JsQualifier("chrome.windows")

package chrome.windows.constant

import chrome.windows.CreateType

@JsName("CreateType")
internal external object CreateTypeJsEnum {

	val NORMAL: CreateType
	val POPUP: CreateType
	val PANEL: CreateType
}