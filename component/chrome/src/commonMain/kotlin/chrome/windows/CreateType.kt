package chrome.windows

/**
 * Specifies what type of browser window to create.
 * 'panel' is deprecated and is available only to existing whitelisted extensions on Chrome OS.
 * @since Chrome 44
 */
typealias CreateType = String

enum class CreateTypeEnum {

	/** Specifies the window as a standard window. */
	normal,

	/** Specifies the window as a popup window. */
	popup,

	/** @deprecated Specifies the window as a panel. */
	panel;

	val value: CreateType = name

	companion object {

		fun enumValueOf(value: CreateType): CreateTypeEnum = valueOf(value)
	}
}