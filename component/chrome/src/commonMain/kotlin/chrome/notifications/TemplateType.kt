package chrome.notifications

import chrome.notifications.constant.TemplateTypeJsEnum

typealias TemplateType = String

enum class TemplateTypeEnum(private val valueProvider: TemplateTypeJsEnum.() -> TemplateType) {

	/** Contains an icon, title, message, expandedMessage, and up to two buttons. */
	BASIC({ BASIC }),

	/** Contains an icon, title, message, expandedMessage, image, and up to two buttons. */
	IMAGE({ IMAGE }),

	/** Contains an icon, title, message, items, and up to two buttons. Users on Mac OS X only see the first item. */
	LIST({ LIST }),

	/** Contains an icon, title, message, progress, and up to two buttons. */
	PROGRESS({ PROGRESS });

	val value: TemplateType get() = valueProvider(TemplateTypeJsEnum)

	companion object {

		fun enumValueOf(value: TemplateType): TemplateTypeEnum = valueOf(value)
	}
}