package chrome.tabs

fun UpdateProperties(
	/** Whether the tab should be pinned. */
	pinned: Boolean? = null,
	/** The ID of the tab that opened this tab. If specified, the opener tab must be in the same window as this tab. */
	openerTabId: Int? = null,
	/** A URL to navigate the tab to. JavaScript URLs are not supported; use {@link scripting.executeScript} instead. */
	url: String? = null,
	/** Adds or removes the tab from the current selection. */
	highlighted: Boolean? = null,
	/** Whether the tab should be active. Does not affect whether the window is focused (see {@link windows.update}).*/
	active: Boolean? = null,
	/**
	 * Whether the tab should be selected.
	 * @deprecated since Chrome 33. Please use {@link highlighted}.
	 */
	selected: Boolean? = null,
	/**
	 * Whether the tab should be muted.
	 * @since Chrome 45
	 */
	muted: Boolean? = null,
	/**
	 * Whether the tab should be discarded automatically by the browser when resources are low.
	 * @since Chrome 54
	 */
	autoDiscardable: Boolean? = null,
): UpdateProperties =
	js("{}").unsafeCast<UpdateProperties>().apply {
		this.pinned = pinned
		this.openerTabId = openerTabId
		this.url = url
		this.highlighted = highlighted
		this.active = active
		this.selected = selected
		this.muted = muted
		this.autoDiscardable = autoDiscardable
	}