package chrome.windows

/**
 * The type of browser window this is. In some circumstances a window may not be assigned a `type` property; for example, when querying closed windows from the {@link sessions} API.
 * @since Chrome 44
 */
typealias WindowType = String

enum class WindowTypeEnum {

	/** A normal browser window. */
	normal,

	/** A browser popup. */
	popup,

	/** @deprecated A Chrome App panel-style window. Extensions can only see their own panel windows. */
	panel,

	/** @deprecated A Chrome App window. Extensions can only see their app own windows. */
	app,

	/** A Developer Tools window. */
	devtools;

	val value: WindowType = name

	companion object {

		fun enumValueOf(value: WindowType): WindowTypeEnum = valueOf(value)
	}
}