package chrome.tabs

fun ReloadProperties(
	/** Whether to bypass local caching. Defaults to `false`. */
	bypassCache: Boolean? = false,
): ReloadProperties =
	js("{}").unsafeCast<ReloadProperties>().apply {
		this.bypassCache = bypassCache
	}