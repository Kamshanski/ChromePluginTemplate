@file:JsQualifier("chrome.runtime")

package chrome.runtime.constant

import chrome.runtime.OnRestartRequiredReason

@JsName("OnRestartRequiredReason")
internal external object OnRestartRequiredReasonJsEnum {

	val APP_UPDATE: OnRestartRequiredReason
	val OS_UPDATE: OnRestartRequiredReason
	val PERIODIC: OnRestartRequiredReason
}