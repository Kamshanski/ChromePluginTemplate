@file:JsQualifier("chrome.runtime")

package chrome.runtime.constant

import chrome.runtime.RequestUpdateCheckStatus

@JsName("RequestUpdateCheckStatus")
internal external object RequestUpdateCheckStatusJsEnum {

	val THROTTLED: RequestUpdateCheckStatus
	val NO_UPDATE: RequestUpdateCheckStatus
	val UPDATE_AVAILABLE: RequestUpdateCheckStatus
}