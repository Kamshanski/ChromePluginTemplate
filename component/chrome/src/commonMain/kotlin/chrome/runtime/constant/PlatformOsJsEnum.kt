@file:JsQualifier("chrome.runtime")

package chrome.runtime.constant

import chrome.runtime.PlatformOs

@JsName("PlatformOs")
internal external object PlatformOsJsEnum {

	val MAC: PlatformOs
	val WIN: PlatformOs
	val ANDROID: PlatformOs
	val CROS: PlatformOs
	val LINUX: PlatformOs
	val OPENBSD: PlatformOs
	val FUCHSIA: PlatformOs
}