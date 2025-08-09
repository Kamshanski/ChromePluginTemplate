@file:JsQualifier("chrome.tabs")

package chrome.tabs.constant

import chrome.tabs.MutedInfoReason

@JsName("MutedInfoReason")
internal external object MutedInfoReasonJsEnum {

	val USER: MutedInfoReason
	val CAPTURE: MutedInfoReason
	val EXTENSION: MutedInfoReason
}