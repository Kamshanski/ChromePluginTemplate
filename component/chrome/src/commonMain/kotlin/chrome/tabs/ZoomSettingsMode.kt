package chrome.tabs

import chrome.tabs.constant.ZoomSettingsModeJsEnum

/**
 * Defines how zoom changes are handled, i.e., which entity is responsible for the actual scaling of the page; defaults to `automatic`.
 * @since Chrome 44
 */
typealias ZoomSettingsMode = String

enum class ZoomSettingsModeEnum(private val valueProvider: ZoomSettingsModeJsEnum.() -> ZoomSettingsMode) {

	/** Zoom changes are handled automatically by the browser. */
	AUTOMATIC({ AUTOMATIC }),

	/** Overrides the automatic handling of zoom changes. The `onZoomChange` event will still be dispatched, and it is the extension's responsibility to listen for this event and manually scale the page. This mode does not support `per-origin` zooming, and thus ignores the `scope` zoom setting and assumes `per-tab`. */
	MANUAL({ MANUAL }),

	/** Disables all zooming in the tab. The tab reverts to the default zoom level, and all attempted zoom changes are ignored. */
	DISABLED({ DISABLED }),
	;

	val value: ZoomSettingsMode get() = valueProvider(ZoomSettingsModeJsEnum)

	companion object {

		fun enumValueOf(value: ZoomSettingsMode): ZoomSettingsModeEnum = ZoomSettingsModeEnum.valueOf(value)
	}
}