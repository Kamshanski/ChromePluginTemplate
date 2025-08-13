@file:JsQualifier("chrome.storage")

package chrome.storage.constant

import chrome.storage.AccessLevel

@JsName("AccessLevel")
internal external object AccessLevelJsEnum {

	val TRUSTED_CONTEXTS: AccessLevel
	val TRUSTED_AND_UNTRUSTED_CONTEXTS: AccessLevel
}