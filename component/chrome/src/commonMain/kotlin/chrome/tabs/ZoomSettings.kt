package chrome.tabs

/** Defines how zoom changes in a tab are handled and at what scope. */
external interface ZoomSettings {

	/** Defines how zoom changes are handled, i.e., which entity is responsible for the actual scaling of the page; defaults to `automatic`. */
	var mode: ZoomSettingsMode?

	/** Defines whether zoom changes persist for the page's origin, or only take effect in this tab; defaults to `per-origin` when in `automatic` mode, and `per-tab` otherwise. */
	var scope: ZoomSettingsScope?

	/**
	 * Used to return the default zoom level for the current tab in calls to {@link tabs.getZoomSettings}.
	 * @since Chrome 43
	 */
	var defaultZoomFactor: Double?
}

fun ZoomSettings(
	/** Defines how zoom changes are handled, i.e., which entity is responsible for the actual scaling of the page; defaults to `automatic`. */
	mode: ZoomSettingsMode = ZoomSettingsModeEnum.AUTOMATIC.value,
	/** Defines whether zoom changes persist for the page's origin, or only take effect in this tab; defaults to `per-origin` when in `automatic` mode, and `per-tab` otherwise. */
	scope: ZoomSettingsScope? = null,
	/**
	 * Used to return the default zoom level for the current tab in calls to {@link tabs.getZoomSettings}.
	 * @since Chrome 43
	 */
	defaultZoomFactor: Double? = null,
): ZoomSettings =
	js("{}").unsafeCast<ZoomSettings>().apply {
		this.mode = mode
		this.scope = scope
		this.defaultZoomFactor = defaultZoomFactor
	}