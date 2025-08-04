@file:JsQualifier("chrome.tabs")

package chrome.tabs.constant

import chrome.tabs.TabStatus

@JsName("TabStatus")
internal external object TabStatusJsEnum {

	val UNLOADED: TabStatus
	val LOADING: TabStatus
	val COMPLETE: TabStatus
}