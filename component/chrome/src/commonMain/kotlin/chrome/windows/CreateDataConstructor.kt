package chrome.windows

fun CreateData(
	/** The ID of the tab to add to the new window. */
	tabId: Int? = null,
	/** A URL or array of URLs to open as tabs in the window. Fully-qualified URLs must include a scheme, e.g., 'http://www.google.com', not 'www.google.com'. Non-fully-qualified URLs are considered relative within the extension. Defaults to the New Tab Page. */
	url: Any? = null,
	/** The number of pixels to position the new window from the top edge of the screen. If not specified, the new window is offset naturally from the last focused window. This value is ignored for panels. */
	top: Int? = null,
	/** The height in pixels of the new window, including the frame. If not specified, defaults to a natural height. */
	height: Int? = null,
	/** The width in pixels of the new window, including the frame. If not specified, defaults to a natural width. */
	width: Int? = null,
	/** If `true`, opens an active window. If `false`, opens an inactive window. */
	focused: Boolean? = null,
	/** Whether the new window should be an incognito window. */
	incognito: Boolean? = null,
	/** Specifies what type of browser window to create. */
	type: CreateType? = null,
	/** The number of pixels to position the new window from the left edge of the screen. If not specified, the new window is offset naturally from the last focused window. This value is ignored for panels. */
	left: Int? = null,
	/**
	 * The initial state of the window. The `minimized`, `maximized`, and `fullscreen` states cannot be combined with `left`, `top`, `width`, or `height`.
	 * @since Chrome 44
	 */
	state: WindowState? = null,
	/**
	 * If `true`, the newly-created window's 'window.opener' is set to the caller and is in the same [unit of related browsing contexts](https://www.w3.org/TR/html51/browsers.html#unit-of-related-browsing-contexts) as the caller.
	 * @since Chrome 64
	 */
	setSelfAsOpener: Boolean? = null,
): CreateData =
	js("{}").unsafeCast<CreateData>().apply {
		this.tabId = tabId
		this.url = url
		this.top = top
		this.height = height
		this.width = width
		this.focused = focused
		this.incognito = incognito
		this.type = type
		this.left = left
		this.state = state
		this.setSelfAsOpener = setSelfAsOpener
	}