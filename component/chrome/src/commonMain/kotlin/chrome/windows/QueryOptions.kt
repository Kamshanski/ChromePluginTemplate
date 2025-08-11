package chrome.windows

import kotlin.js.collections.JsReadonlyArray

/** @since Chrome 88 */
interface QueryOptions {

	/** If true, the {@link windows.Window} object has a `tabs` property that contains a list of the {@link tabs.Tab} objects. The `Tab` objects only contain the `url`, `pendingUrl`, `title`, and `favIconUrl` properties if the extension's manifest file includes the `"tabs"` permission. */
	var populate: Boolean?

	/** If set, the {@link windows.Window} returned is filtered based on its type. If unset, the default filter is set to `['normal', 'popup']`. */
	var windowTypes: JsReadonlyArray<WindowType>?
}

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