package chrome.windows

interface UpdateInfo {

	/** The offset from the top edge of the screen to move the window to in pixels. This value is ignored for panels. */
	var top: Double?

	/** If `true`, causes the window to be displayed in a manner that draws the user's attention to the window, without changing the focused window. The effect lasts until the user changes focus to the window. This option has no effect if the window already has focus. Set to `false` to cancel a previous `drawAttention` request. */
	var drawAttention: Boolean?

	/** The height to resize the window to in pixels. This value is ignored for panels. */
	var height: Double?

	/** The width to resize the window to in pixels. This value is ignored for panels. */
	var width: Double?

	/** The new state of the window. The 'minimized', 'maximized', and 'fullscreen' states cannot be combined with 'left', 'top', 'width', or 'height'. */
	var state: WindowState?

	/** If `true`, brings the window to the front; cannot be combined with the state 'minimized'. If `false`, brings the next window in the z-order to the front; cannot be combined with the state 'fullscreen' or 'maximized'. */
	var focused: Boolean?

	/** The offset from the left edge of the screen to move the window to in pixels. This value is ignored for panels. */
	var left: Double?
}