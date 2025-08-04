package chrome.windows

import chrome.windows.constant.WindowStateJsEnum

/**
 * The state of this browser window. In some circumstances a window may not be assigned a `state` property; for example, when querying closed windows from the {@link sessions} API.
 * @since Chrome 44
 */
typealias WindowState = String

enum class WindowStateEnum(private val valueProvider: WindowStateJsEnum.() -> WindowState) {

	/** Normal window state (not minimized, maximized, or fullscreen). */
	NORMAL({ NORMAL }),

	/** Minimized window state. */
	MINIMIZED({ MINIMIZED }),

	/** Maximized window state. */
	MAXIMIZED({ MAXIMIZED }),

	/** Fullscreen window state. */
	FULLSCREEN({ FULLSCREEN }),

	/** Locked fullscreen window state. This fullscreen state cannot be exited by user action and is available only to allowlisted extensions on Chrome OS. */
	LOCKED_FULLSCREEN({ LOCKED_FULLSCREEN }),
	;

	val value: WindowState get() = valueProvider(WindowStateJsEnum)

	companion object {

		fun enumValueOf(value: WindowState): WindowStateEnum = valueOf(value)
	}
}