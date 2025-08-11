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

@OptIn(ExperimentalJsExport::class)
fun ContextFilter(
	contextIds: List<String>? = null,
	contextTypes: List<ContextType>? = null,
	documentIds: List<String>? = null,
	documentOrigins: List<String>? = null,
	documentUrls: List<String>? = null,
	frameIds: List<Double>? = null,
	incognito: Boolean? = null,
	tabIds: List<Double>? = null,
	windowIds: List<Double>? = null,
): ContextFilter =
	js("{}").unsafeCast<ContextFilter>().apply {
		this.contextIds = contextIds?.asJsReadonlyArrayView()
		this.contextTypes = contextTypes?.asJsReadonlyArrayView()
		this.documentIds = documentIds?.asJsReadonlyArrayView()
		this.documentOrigins = documentOrigins?.asJsReadonlyArrayView()
		this.documentUrls = documentUrls?.asJsReadonlyArrayView()
		this.frameIds = frameIds?.asJsReadonlyArrayView()
		this.incognito = incognito
		this.tabIds = tabIds?.asJsReadonlyArrayView()
		this.windowIds = windowIds?.asJsReadonlyArrayView()
	}