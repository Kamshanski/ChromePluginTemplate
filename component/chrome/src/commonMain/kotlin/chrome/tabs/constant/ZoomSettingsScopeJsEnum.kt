@file:JsQualifier("chrome.tabs")

package chrome.tabs.constant

import chrome.tabs.ZoomSettingsScope

@JsName("ZoomSettingsScope")
internal external object ZoomSettingsScopeJsEnum {
	val PER_ORIGIN: ZoomSettingsScope
	val PER_TAB: ZoomSettingsScope
}