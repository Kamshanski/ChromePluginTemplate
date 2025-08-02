package chrome.extensiontypes

fun InjectDetails(
	/**
	 * JavaScript or CSS code to inject.
	 *
	 * **Warning:** Be careful using the `code` parameter. Incorrect use of it may open your extension to cross site scripting attacks
	 */
	code: String? = null,
	/** JavaScript or CSS file to inject. */
	file: String? = null,
	/** If allFrames is `true`, implies that the JavaScript or CSS should be injected into all frames of current page. By default, it's `false` and is only injected into the top frame. If `true` and `frameId` is set, then the code is inserted in the selected frame and all of its child frames. */
	allFrames: Boolean = false,
	/**
	 * The origin of the CSS to inject. This may only be specified for CSS, not JavaScript. Defaults to `"author"`.
	 * @since Chrome 66
	 */
	cssOrigin: CSSOrigin = CSSOriginEnum.author.value,
	/**
	 * The frame where the script or CSS should be injected. Defaults to 0 (the top-level frame).
	 * @since Chrome 50
	 */
	frameId: Int = 0,
	/** If matchAboutBlank is true, then the code is also injected in about:blank and about:srcdoc frames if your extension has access to its parent document. Code cannot be inserted in top-level about:-frames. By default it is `false`. */
	matchAboutBlank: Boolean? = false,
	/** The soonest that the JavaScript or CSS will be injected into the tab. Defaults to "document_idle". */
	runAt: RunAt = RunAtEnum.document_idle.value,
): InjectDetails =
	js("{}").unsafeCast<InjectDetails>().apply {
		this.allFrames = allFrames
		this.code = code
		this.cssOrigin = cssOrigin
		this.file = file
		this.frameId = frameId
		this.matchAboutBlank = matchAboutBlank
		this.runAt = runAt
	}