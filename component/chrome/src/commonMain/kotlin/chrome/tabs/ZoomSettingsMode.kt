package chrome.tabs

import chrome.extensiontypes.RunAt
import chrome.extensiontypes.RunAtEnum

/**
 * Defines how zoom changes are handled, i.e., which entity is responsible for the actual scaling of the page; defaults to `automatic`.
 * @since Chrome 44
 */
typealias ZoomSettingsMode = String

enum class ZoomSettingsModeEnum {

	/** Zoom changes are handled automatically by the browser. */
	automatic,

	/** Overrides the automatic handling of zoom changes. The `onZoomChange` event will still be dispatched, and it is the extension's responsibility to listen for this event and manually scale the page. This mode does not support `per-origin` zooming, and thus ignores the `scope` zoom setting and assumes `per-tab`. */
	manual,

	/** Disables all zooming in the tab. The tab reverts to the default zoom level, and all attempted zoom changes are ignored. */
	disabled,
	;


	val value: RunAt = name

	companion object {

		fun enumValueOf(value: RunAt): RunAtEnum = RunAtEnum.valueOf(value)
	}
}