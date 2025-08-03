package chrome.runtime

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