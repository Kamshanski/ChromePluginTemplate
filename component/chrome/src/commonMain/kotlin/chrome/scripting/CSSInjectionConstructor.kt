package chrome.scripting

import kotlin.js.collections.JsReadonlyArray

/**
 * @see chrome.scripting.CSSInjection
 */
fun CSSInjection(
	/**
	 * The style origin for the injection. Defaults to 'AUTHOR'.
	 */
	origin: StyleOrigin? = null,
	/**
	 * Details specifying the target into which to insert the CSS.
	 */
	target: InjectionTarget,
	/**
	 * A string containing the CSS to inject. Exactly one of files and css must be specified.
	 */
	css: String? = null,
): CSSInjection =
	js("{}").unsafeCast<CSSInjection>().apply {
		this.origin = origin
		this.target = target
		this.css = css
	}

/**
 * @see chrome.scripting.CSSInjection
 */
fun CSSInjection(
	/**
	 * The style origin for the injection. Defaults to 'AUTHOR'.
	 */
	origin: StyleOrigin? = null,
	/**
	 * Details specifying the target into which to insert the CSS.
	 */
	target: InjectionTarget,
	/**
	 * The path of the CSS files to inject, relative to the extension's root directory. Exactly one of files and css must be specified.
	 */
	files: JsReadonlyArray<String>? = null,
): CSSInjection =
	js("{}").unsafeCast<CSSInjection>().apply {
		this.origin = origin
		this.target = target
		this.files = files
	}