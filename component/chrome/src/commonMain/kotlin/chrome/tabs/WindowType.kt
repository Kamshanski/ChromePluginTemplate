package chrome.tabs

import chrome.tabs.constant.WindowTypeJsEnum

typealias WindowType = String

/** The type of window. */
enum class WindowTypeEnum(private val valueProvider: WindowTypeJsEnum.() -> WindowType) {

	NORMAL({ NORMAL }),
	POPUP({ POPUP }),
	PANEL({ PANEL }),
	APP({ APP }),
	DEVTOOLS({ DEVTOOLS }),
	;

	val value: WindowType get() = valueProvider(WindowTypeJsEnum)

	companion object {

		fun enumValueOf(value: WindowType): WindowTypeEnum = WindowTypeEnum.valueOf(value)
	}
}