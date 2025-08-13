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

/**
 * allFrames = true
 * @see chrome.scripting.InjectionTarget
 */
fun InjectionTarget(
	/** The ID of the tab into which to inject. */
	tabId: Int,
): InjectionTarget =
	js("{}").unsafeCast<InjectionTarget>().apply {
		this.tabId = tabId
		this.allFrames = true
	}

/**
 * Inject into documents
 * @see chrome.scripting.InjectionTarget
 */
fun InjectionTarget(
	/** The ID of the tab into which to inject. */
	tabId: Int,
	/**
	 * The IDs of specific documentIds to inject into. This must not be set if frameIds is set.
	 *
	 * @since Chrome 106
	 */
	documentIds: List<String>,
): InjectionTarget =
	js("{}").unsafeCast<InjectionTarget>().apply {
		this.tabId = tabId
		this.documentIds = documentIds.asJsReadonlyArrayView()
	}

/**
 * Inject into frames
 * @see chrome.scripting.InjectionTarget
 */
fun InjectionTarget(
	/** The ID of the tab into which to inject. */
	tabId: Int,
	/** The IDs of specific frames to inject into. */
	frameIds: List<Int>,
): InjectionTarget =
	js("{}").unsafeCast<InjectionTarget>().apply {
		this.tabId = tabId
		this.frameIds = frameIds.asJsReadonlyArrayView()
	}