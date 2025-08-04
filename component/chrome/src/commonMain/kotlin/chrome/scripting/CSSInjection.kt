@file:JsQualifier("chrome.scripting")

package chrome.scripting

import kotlin.js.collections.JsReadonlyArray

external interface CSSInjection {

	/**
	 * The style origin for the injection. Defaults to 'AUTHOR'.
	 */
	var origin: StyleOrigin?
	/**
	 * Details specifying the target into which to insert the CSS.
	 */
	var target: InjectionTarget
	/**
	 * A string containing the CSS to inject. Exactly one of files and css must be specified.
	 */
	var css: String?
	/**
	 * The path of the CSS files to inject, relative to the extension's root directory. Exactly one of files and css must be specified.
	 */
	var files: JsReadonlyArray<String>?
}

/* {
    origin?: `${StyleOrigin}` | undefined;
    target: InjectionTarget;
} & ({
    css: string;
    files?: never | undefined;
} | {
    css?: never | undefined;
    files: string[];
}) */