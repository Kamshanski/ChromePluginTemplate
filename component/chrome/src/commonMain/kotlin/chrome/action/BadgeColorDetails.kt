package chrome.action

import chrome.extensiontypes.ColorArray

external interface BadgeColorDetails {

	/** An array of four integers in the range [0,255] that make up the RGBA color of the badge. For example, opaque red is `[255, 0, 0, 255]`. Can also be a string with a CSS value, with opaque red being `#FF0000` or `#F00`. */
	var color: Any /* string | ColorArray */

	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	var tabId: Int?
}

fun BadgeColorDetails(
	/** An array of four integers in the range [0,255] that make up the RGBA color of the badge. For example, opaque red is `[255, 0, 0, 255]`. */
	color: ColorArray,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
): BadgeColorDetails =
	js("{}").unsafeCast<BadgeColorDetails>().apply {
		this.color = color
		this.tabId = tabId
	}

fun BadgeColorDetails(
	/** A string with a CSS value, with opaque red being `#FF0000` or `#F00`. */
	color: String,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
): BadgeColorDetails =
	js("{}").unsafeCast<BadgeColorDetails>().apply {
		this.color = color
		this.tabId = tabId
	}