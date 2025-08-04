package chrome.windows

fun QueryOptions(
	/** If true, the {@link windows.Window} object has a `tabs` property that contains a list of the {@link tabs.Tab} objects. The `Tab` objects only contain the `url`, `pendingUrl`, `title`, and `favIconUrl` properties if the extension's manifest file includes the `"tabs"` permission. */
	populate: Boolean? = null,
	/** If set, the {@link windows.Window} returned is filtered based on its type. If unset, the default filter is set to `['normal', 'popup']`. */
	windowTypes: List<WindowTypeEnum>? = listOf(WindowTypeEnum.NORMAL, WindowTypeEnum.POPUP),
): QueryOptions =
	js("{}").unsafeCast<QueryOptions>().apply {
		this.populate = populate
		this.windowTypes = windowTypes?.map { it.value }?.asJsReadonlyArrayView()
	}