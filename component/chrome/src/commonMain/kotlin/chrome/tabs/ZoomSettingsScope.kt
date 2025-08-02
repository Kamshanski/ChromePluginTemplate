package chrome.tabs

import chrome.extensiontypes.RunAt
import chrome.extensiontypes.RunAtEnum

/**
 * Defines whether zoom changes persist for the page's origin, or only take effect in this tab; defaults to `per-origin` when in `automatic` mode, and `per-tab` otherwise.
 * @since Chrome 44
 */
typealias ZoomSettingsScope = String

enum class ZoomSettingsScopeEnum {

	/** Zoom changes persist in the zoomed page's origin, i.e., all other tabs navigated to that same origin are zoomed as well. Moreover, `per-origin` zoom changes are saved with the origin, meaning that when navigating to other pages in the same origin, they are all zoomed to the same zoom factor. The `per-origin` scope is only available in the `automatic` mode. */
	per_origin,

	/** Zoom changes only take effect in this tab, and zoom changes in other tabs do not affect the zooming of this tab. Also, `per-tab` zoom changes are reset on navigation; navigating a tab always loads pages with their `per-origin` zoom factors. */
	per_tab,
	;

	val value: RunAt = name

	companion object {

		fun enumValueOf(value: RunAt): RunAtEnum = RunAtEnum.valueOf(value)
	}
}