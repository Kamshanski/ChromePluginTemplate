@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

/**
 * A filter to match against certain extension contexts. Matching contexts must match all specified filters; any filter that is not specified matches all available contexts. Thus, a filter of `{}` will match all available contexts.
 * @since Chrome 114
 */
external interface ContextFilter {

	var contextIds: JsReadonlyArray<String>?
	var contextTypes: JsReadonlyArray<ContextType>?
	var documentIds: JsReadonlyArray<String>?
	var documentOrigins: JsReadonlyArray<String>?
	var documentUrls: JsReadonlyArray<String>?
	var frameIds: JsReadonlyArray<Double>?
	var incognito: Boolean?
	var tabIds: JsReadonlyArray<Double>?
	var windowIds: JsReadonlyArray<Double>?
}