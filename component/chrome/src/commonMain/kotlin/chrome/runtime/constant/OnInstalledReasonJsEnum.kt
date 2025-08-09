@file:JsQualifier("chrome.runtime")

package chrome.runtime.constant

import chrome.runtime.OnInstalledReason

@JsName("OnInstalledReason")
internal external object OnInstalledReasonJsEnum {

	val INSTALL: OnInstalledReason
	val UPDATE: OnInstalledReason
	val CHROME_UPDATE: OnInstalledReason
	val SHARED_MODULE_UPDATE: OnInstalledReason
}