package chrome.windows

/**
 * The state of this browser window. In some circumstances a window may not be assigned a `state` property; for example, when querying closed windows from the {@link sessions} API.
 * @since Chrome 44
 */
typealias WindowState = String

enum class WindowStateEnum {

	/** Normal window state (not minimized, maximized, or fullscreen). */
	normal,

	/** Minimized window state. */
	minimized,

	/** Maximized window state. */
	maximized,

	/** Fullscreen window state. */
	fullscreen,

	/** Locked fullscreen window state. This fullscreen state cannot be exited by user action and is available only to allowlisted extensions on Chrome OS. */
	`locked-fullscreen`,
	;

	val value: WindowState = name

	companion object {

		fun enumValueOf(value: WindowState): WindowStateEnum = valueOf(value)
	}
}