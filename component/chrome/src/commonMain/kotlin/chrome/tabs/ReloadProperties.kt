package chrome.tabs

external interface ReloadProperties {

	/** Whether to bypass local caching. Defaults to `false`. */
	var bypassCache: Boolean?
}

fun ReloadProperties(
	/** Whether to bypass local caching. Defaults to `false`. */
	bypassCache: Boolean? = false,
): ReloadProperties =
	js("{}").unsafeCast<ReloadProperties>().apply {
		this.bypassCache = bypassCache
	}