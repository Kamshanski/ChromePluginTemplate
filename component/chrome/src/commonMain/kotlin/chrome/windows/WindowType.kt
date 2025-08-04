package chrome.windows

import chrome.windows.constant.WindowTypeJsEnum

/**
 * The type of browser window this is. In some circumstances a window may not be assigned a `type` property; for example, when querying closed windows from the {@link sessions} API.
 * @since Chrome 44
 */
typealias WindowType = String

enum class WindowTypeEnum(private val valueProvider: WindowTypeJsEnum.() -> WindowType) {

	/** A normal browser window. */
	NORMAL({ NORMAL }),

	/** A browser popup. */
	POPUP({ POPUP }),

	/** @deprecated A Chrome App panel-style window. Extensions can only see their own panel windows. */
	PANEL({ PANEL }),

	/** @deprecated A Chrome App window. Extensions can only see their app own windows. */
	APP({ APP }),

	/** A Developer Tools window. */
	DEVTOOLS({ DEVTOOLS });

	val value: WindowType get() = valueProvider(WindowTypeJsEnum)

	companion object {

		fun enumValueOf(value: WindowType): WindowTypeEnum = valueOf(value)
	}
}