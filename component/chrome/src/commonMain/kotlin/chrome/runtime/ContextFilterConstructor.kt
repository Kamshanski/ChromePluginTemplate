package chrome.runtime

import dev.kamshanski.chrome.util.common.mapToArray

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
		this.contextIds = contextIds?.mapToArray { it }
		this.contextTypes = contextTypes?.mapToArray { it }
		this.documentIds = documentIds?.mapToArray { it }
		this.documentOrigins = documentOrigins?.mapToArray { it }
		this.documentUrls = documentUrls?.mapToArray { it }
		this.frameIds = frameIds?.mapToArray { it }
		this.incognito = incognito
		this.tabIds = tabIds?.mapToArray { it }
		this.windowIds = windowIds?.mapToArray { it }
	}