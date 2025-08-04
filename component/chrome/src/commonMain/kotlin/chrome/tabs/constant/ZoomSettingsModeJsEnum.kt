@file:JsQualifier("chrome.tabs")

package chrome.tabs.constant

import chrome.tabs.ZoomSettingsMode

@JsName("ZoomSettingsMode")
internal external object ZoomSettingsModeJsEnum {

	val AUTOMATIC: ZoomSettingsMode
	val MANUAL: ZoomSettingsMode
	val DISABLED: ZoomSettingsMode
}