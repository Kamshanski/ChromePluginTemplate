package chrome.extensiontypes

/** Details of the script or CSS to inject. Either the code or the file property must be set, but both may not be set at the same time. */
external interface InjectDetails {

	/** If allFrames is `true`, implies that the JavaScript or CSS should be injected into all frames of current page. By default, it's `false` and is only injected into the top frame. If `true` and `frameId` is set, then the code is inserted in the selected frame and all of its child frames. */
	var allFrames: Boolean?

	/**
	 * JavaScript or CSS code to inject.
	 *
	 * **Warning:** Be careful using the `code` parameter. Incorrect use of it may open your extension to cross site scripting attacks
	 */
	var code: String?

	/**
	 * The origin of the CSS to inject. This may only be specified for CSS, not JavaScript. Defaults to `"author"`.
	 * @since Chrome 66
	 */
	var cssOrigin: CSSOrigin?

	/** JavaScript or CSS file to inject. */
	var file: String?

	/**
	 * The frame where the script or CSS should be injected. Defaults to 0 (the top-level frame).
	 * @since Chrome 50
	 */
	var frameId: Int?

	/** If matchAboutBlank is true, then the code is also injected in about:blank and about:srcdoc frames if your extension has access to its parent document. Code cannot be inserted in top-level about:-frames. By default it is `false`. */
	var matchAboutBlank: Boolean?

	/** The soonest that the JavaScript or CSS will be injected into the tab. Defaults to "document_idle". */
	var runAt: RunAt?
}

fun InjectDetails(
	/** If allFrames is `true`, implies that the JavaScript or CSS should be injected into all frames of current page. By default, it's `false` and is only injected into the top frame. If `true` and `frameId` is set, then the code is inserted in the selected frame and all of its child frames. */
	allFrames: Boolean? = null,
	/**
	 * JavaScript or CSS code to inject.
	 *
	 * **Warning:** Be careful using the `code` parameter. Incorrect use of it may open your extension to cross site scripting attacks
	 */
	code: String? = null,
	/**
	 * The origin of the CSS to inject. This may only be specified for CSS, not JavaScript. Defaults to `"author"`.
	 * @since Chrome 66
	 */
	cssOrigin: CSSOrigin? = null,
	/** JavaScript or CSS file to inject. */
	file: String? = null,
	/**
	 * The frame where the script or CSS should be injected. Defaults to 0 (the top-level frame).
	 * @since Chrome 50
	 */
	frameId: Int? = null,
	/** If matchAboutBlank is true, then the code is also injected in about:blank and about:srcdoc frames if your extension has access to its parent document. Code cannot be inserted in top-level about:-frames. By default it is `false`. */
	matchAboutBlank: Boolean? = null,
	/** The soonest that the JavaScript or CSS will be injected into the tab. Defaults to "document_idle". */
	runAt: RunAt? = null,
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

fun InjectDetails(
	/** If allFrames is `true`, implies that the JavaScript or CSS should be injected into all frames of current page. By default, it's `false` and is only injected into the top frame. If `true` and `frameId` is set, then the code is inserted in the selected frame and all of its child frames. */
	allFrames: Boolean? = null,
	/**
	 * The origin of the CSS to inject. This may only be specified for CSS, not JavaScript. Defaults to `"author"`.
	 * @since Chrome 66
	 */
	cssOrigin: CSSOrigin? = null,
	/** JavaScript or CSS file to inject. */
	file: String? = null,
	/**
	 * The frame where the script or CSS should be injected. Defaults to 0 (the top-level frame).
	 * @since Chrome 50
	 */
	frameId: Int? = null,
	/** If matchAboutBlank is true, then the code is also injected in about:blank and about:srcdoc frames if your extension has access to its parent document. Code cannot be inserted in top-level about:-frames. By default it is `false`. */
	matchAboutBlank: Boolean? = null,
	/** The soonest that the JavaScript or CSS will be injected into the tab. Defaults to "document_idle". */
	runAt: RunAt? = null,
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