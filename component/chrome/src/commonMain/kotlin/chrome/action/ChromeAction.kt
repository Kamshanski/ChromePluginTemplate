@file:JsQualifier("chrome")

package chrome.action

import chrome.events.Event
import chrome.extensiontypes.ColorArray
import kotlin.js.Promise

/**
 * Use the `chrome.action` API to control the extension's icon in the Google Chrome toolbar.
 * The action icons are displayed in the browser toolbar next to the omnibox. After installation, these appear in the extensions menu (the puzzle piece icon). Users can pin your extension icon to the toolbar.
 *
 * Manifest: "action"
 * @since Chrome 88, MV3
 */
@Suppress("unused")
@JsName("action")
external object ChromeAction {

	/**
	 * Disables the action for a tab.
	 * @param tabId The ID of the tab for which you want to modify the action.
	 *
	 * Can return its result via Promise.
	 */
	fun disable(tabId: Int = definedExternally): Promise<Unit>
	fun disable(callback: () -> Unit)
	fun disable(tabId: Int?, callback: () -> Unit)

	/**
	 * Enables the action for a tab. By default, actions are enabled.
	 * @param tabId The ID of the tab for which you want to modify the action.
	 *
	 * Can return its result via Promise.
	 */
	fun enable(tabId: Int = definedExternally): Promise<Unit>
	fun enable(callback: () -> Unit)
	fun enable(tabId: Int?, callback: () -> Unit)

	/**
	 * Gets the background color of the action.
	 *
	 * Can return its result via Promise.
	 */
	fun getBadgeBackgroundColor(details: TabDetails): Promise<ColorArray>
	fun getBadgeBackgroundColor(details: TabDetails, callback: (result: ColorArray) -> Unit)

	/**
	 * Gets the badge text of the action. If no tab is specified, the non-tab-specific badge text is returned. If {@link declarativeNetRequest.ExtensionActionOptions.displayActionCountAsBadgeText displayActionCountAsBadgeText} is enabled, a placeholder text will be returned unless the {@link runtime.ManifestPermissions declarativeNetRequestFeedback} permission is present or tab-specific badge text was provided.
	 *
	 * Can return its result via Promise.
	 */
	fun getBadgeText(details: TabDetails): Promise<String>
	fun getBadgeText(details: TabDetails, callback: (result: String) -> Unit)

	/**
	 * Gets the text color of the action.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 110
	 */
	fun getBadgeTextColor(details: TabDetails): Promise<ColorArray>
	fun getBadgeTextColor(details: TabDetails, callback: (result: ColorArray) -> Unit)

	/**
	 * Gets the html document set as the popup for this action.
	 *
	 * Can return its result via Promise.
	 */
	fun getPopup(details: TabDetails): Promise<String>
	fun getPopup(details: TabDetails, callback: (result: String) -> Unit)

	/**
	 * Gets the title of the action.
	 *
	 * Can return its result via Promise.
	 */
	fun getTitle(details: TabDetails): Promise<String>
	fun getTitle(details: TabDetails, callback: (result: String) -> Unit)

	/**
	 * Returns the user-specified settings relating to an extension's action.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 91
	 */
	fun getUserSettings(): Promise<UserSettings>
	fun getUserSettings(callback: (userSettings: UserSettings) -> Unit)

	/**
	 * Indicates whether the extension action is enabled for a tab (or globally if no `tabId` is provided). Actions enabled using only {@link declarativeContent} always return false.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 110
	 */
	fun isEnabled(tabId: Int = definedExternally): Promise<Boolean>
	fun isEnabled(callback: (isEnabled: Boolean) -> Unit)
	fun isEnabled(tabId: Int?, callback: (isEnabled: Boolean) -> Unit)

	/**
	 * Opens the extension's popup. Between Chrome 118 and Chrome 126, this is only available to policy installed extensions.
	 *
	 * @param options Specifies options for opening the popup.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 127
	 */
	fun openPopup(options: OpenPopupOptions = definedExternally): Promise<Unit>
	fun openPopup(callback: () -> Unit)
	fun openPopup(options: OpenPopupOptions?, callback: () -> Unit)

	/**
	 * Sets the background color for the badge.
	 *
	 * Can return its result via Promise.
	 */
	fun setBadgeBackgroundColor(details: BadgeColorDetails): Promise<Unit>
	fun setBadgeBackgroundColor(details: BadgeColorDetails, callback: () -> Unit)

	/**
	 * Sets the badge text for the action. The badge is displayed on top of the icon.
	 *
	 * Can return its result via Promise.
	 */
	fun setBadgeText(details: BadgeTextDetails): Promise<Unit>
	fun setBadgeText(details: BadgeTextDetails, callback: () -> Unit)

	/**
	 * Sets the text color for the badge.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 110
	 */
	fun setBadgeTextColor(details: BadgeColorDetails): Promise<Unit>
	fun setBadgeTextColor(details: BadgeColorDetails, callback: () -> Unit)

	/**
	 * Sets the icon for the action. The icon can be specified either as the path to an image file or as the pixel data from a canvas element, or as dictionary of either one of those. Either the path or the imageData property must be specified.
	 *
	 * Can return its result via Promise.
	 */
	fun setIcon(details: TabIconDetails): Promise<Unit>
	fun setIcon(details: TabIconDetails, callback: () -> Unit)

	/**
	 * Sets the html document to be opened as a popup when the user clicks on the action's icon.
	 *
	 * Can return its result via Promise.
	 */
	fun setPopup(details: PopupDetails): Promise<Unit>
	fun setPopup(details: PopupDetails, callback: () -> Unit)

	/**
	 * Sets the title of the action. This shows up in the tooltip.
	 *
	 * Can return its result via Promise.
	 */
	fun setTitle(details: TitleDetails): Promise<Unit>
	fun setTitle(details: TitleDetails, callback: () -> Unit)

	/** Fired when an action icon is clicked. This event will not fire if the action has a popup. */
	val onClicked: Event<(tab: chrome.tabs.Tab) -> Unit>

	/**
	 * Fired when user-specified settings relating to an extension's action change.
	 * @since Chrome 130
	 */
	val onUserSettingsChanged: Event<(change: UserSettingsChange) -> Unit>
}