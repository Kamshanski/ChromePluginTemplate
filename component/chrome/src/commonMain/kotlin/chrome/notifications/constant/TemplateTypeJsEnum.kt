@file:JsQualifier("chrome.notifications")

package chrome.notifications.constant

import chrome.notifications.TemplateType

@JsName("TemplateType")
internal external object TemplateTypeJsEnum {

	val BASIC: TemplateType
	val IMAGE: TemplateType
	val LIST: TemplateType
	val PROGRESS: TemplateType
}