@file:JsQualifier("chrome.notifications")

package chrome.notifications.constant

import chrome.notifications.PermissionLevel

@JsName("PermissionLevel")
internal external object PermissionLevelJsEnum {

	val GRANTED: PermissionLevel
	val DENIED: PermissionLevel
}