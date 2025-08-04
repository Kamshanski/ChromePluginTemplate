package chrome.runtime

import chrome.runtime.constant.ContextTypeJsEnum

/** @since Chrome 114 */
typealias ContextType = String

enum class ContextTypeEnum(private val valueProvider: ContextTypeJsEnum.() -> ContextType) {

	/** Specifies the context type as a tab */
	TAB({ TAB }),

	/** Specifies the context type as an extension popup window */
	POPUP({ POPUP }),

	/** Specifies the context type as a service worker. */
	BACKGROUND({ BACKGROUND }),

	/** Specifies the context type as an offscreen document. */
	OFFSCREEN_DOCUMENT({ OFFSCREEN_DOCUMENT }),

	/** Specifies the context type as a side panel. */
	SIDE_PANEL({ SIDE_PANEL }),

	/** Specifies the context type as developer tools. */
	DEVELOPER_TOOLS({ DEVELOPER_TOOLS });

	val value: ContextType get() = valueProvider(ContextTypeJsEnum)

	companion object {

		fun enumValueOf(value: ContextType): ContextTypeEnum = valueOf(value)
	}
}