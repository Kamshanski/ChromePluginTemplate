@file:JsQualifier("chrome.runtime")

package chrome.runtime

/**
 * A filter to match against certain extension contexts. Matching contexts must match all specified filters; any filter that is not specified matches all available contexts. Thus, a filter of `{}` will match all available contexts.
 * @since Chrome 114
 */
external interface ContextFilter {

	var contextIds: Array<String>?
	var contextTypes: Array<ContextType>?
	var documentIds: Array<String>?
	var documentOrigins: Array<String>?
	var documentUrls: Array<String>?
	var frameIds: Array<Double>?
	var incognito: Boolean?
	var tabIds: Array<Double>?
	var windowIds: Array<Double>?
}