package chrome.windows

import chrome.windows.constant.CreateTypeJsEnum

/**
 * Specifies what type of browser window to create.
 * 'panel' is deprecated and is available only to existing whitelisted extensions on Chrome OS.
 * @since Chrome 44
 */
typealias CreateType = String

enum class CreateTypeEnum(private val valueProvider: CreateTypeJsEnum.() -> CreateType) {

	/** Specifies the window as a standard window. */
	NORMAL({ NORMAL }),

	/** Specifies the window as a popup window. */
	POPUP({ POPUP }),

	/** @deprecated Specifies the window as a panel. */
	PANEL({ PANEL });

	val value: CreateType get() = valueProvider(CreateTypeJsEnum)

	companion object {

		fun enumValueOf(value: CreateType): CreateTypeEnum = valueOf(value)
	}
}