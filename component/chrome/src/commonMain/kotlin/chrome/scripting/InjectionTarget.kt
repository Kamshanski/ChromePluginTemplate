@file:JsQualifier("chrome.scripting")

package chrome.scripting

import kotlin.js.collections.JsReadonlyArray

external interface InjectionTarget {

	/**
	 * The ID of the tab into which to inject.
	 */
	var tabId: Int

	/**
	 * Whether the script should inject into all frames within the tab. Defaults to false. This must not be true if frameIds is specified.
	 */
	var allFrames: Boolean?

	/**
	 * The IDs of specific documentIds to inject into. This must not be set if frameIds is set.
	 *
	 * @since Chrome 106
	 */
	var documentIds: JsReadonlyArray<String>?

	/**
	 * The IDs of specific frames to inject into.
	 */
	var frameIds: JsReadonlyArray<Int>?
}

/* {
    tabId: number;
} & ({
    allFrames?: boolean | undefined;
    documentIds?: never | undefined;
    frameIds?: never | undefined;
} | {
    allFrames?: false | undefined;
    documentIds?: never | undefined;
    frameIds: number[] | undefined;
} | {
    allFrames?: false | undefined;
    documentIds?: string[] | undefined;
    frameIds?: never | undefined;
}) */