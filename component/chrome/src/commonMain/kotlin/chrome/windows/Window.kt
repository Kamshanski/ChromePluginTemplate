package chrome.windows

import chrome.tabs.Tab
import kotlin.js.collections.JsReadonlyArray

interface Window {

	/** Array of {@link tabs.Tab} objects representing the current tabs in the window. */
	var tabs: JsReadonlyArray<Any>? // TODO replace ANY with Tab from chrome.tabs

	/** The offset of the window from the top edge of the screen in pixels. In some circumstances a window may not be assigned a `top` property; for example, when querying closed windows from the {@link sessions} API. */
	var top: Int?

	/** The height of the window, including the frame, in pixels. In some circumstances a window may not be assigned a `height` property, for example when querying closed windows from the {@link sessions} API. */
	var height: Int?

	/** The width of the window, including the frame, in pixels. In some circumstances a window may not be assigned a `width` property; for example, when querying closed windows from the {@link sessions} API. */
	var width: Int?

	/** The state of this browser window. */
	var state: WindowState?

	/** Whether the window is currently the focused window. */
	var focused: Boolean

	/** Whether the window is set to be always on top. */
	var alwaysOnTop: Boolean

	/** Whether the window is incognito. */
	var incognito: Boolean

	/** The type of browser window this is. */
	var type: WindowState?

	/** The ID of the window. Window IDs are unique within a browser session. In some circumstances a window may not be assigned an `ID` property; for example, when querying windows using the {@link sessions} API, in which case a session ID may be present. */
	var id: Int?

	/** The offset of the window from the left edge of the screen in pixels. In some circumstances a window may not be assigned a `left` property; for example, when querying closed windows from the {@link sessions} API. */
	var left: Int?

	/** The session ID used to uniquely identify a window, obtained from the {@link sessions} API. */
	var sessionId: String?
}