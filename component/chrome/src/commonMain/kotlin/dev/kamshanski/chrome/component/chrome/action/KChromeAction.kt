package dev.kamshanski.chrome.component.chrome.action

import chrome.action.BadgeColorDetails
import chrome.action.BadgeTextDetails
import chrome.action.ChromeAction
import chrome.action.OpenPopupOptions
import chrome.action.PopupDetails
import chrome.action.TabDetails
import chrome.action.TabIconDetails
import chrome.action.TitleDetails
import chrome.action.UserSettings
import chrome.action.UserSettingsChange
import chrome.events.Event
import chrome.extensiontypes.ColorArray
import chrome.tabs.Tab
import kotlinx.coroutines.await

/**
 * Use the `chrome.action` API to control the extension's icon in the Google Chrome toolbar.
 * The action icons are displayed in the browser toolbar next to the omnibox. After installation, these appear in the extensions menu (the puzzle piece icon). Users can pin your extension icon to the toolbar.
 *
 * Manifest: "action"
 * @since Chrome 88, MV3
 */
@Suppress("unused")
object KChromeAction {

	/**
	 * Disables the action for a tab.
	 * @param tabId The ID of the tab for which you want to modify the action.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun disable(tabId: Int): Unit = ChromeAction.disable(tabId).await()
	suspend fun disable(): Unit = ChromeAction.disable().await()

	/**
	 * Enables the action for a tab. By default, actions are enabled.
	 * @param tabId The ID of the tab for which you want to modify the action.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun enable(tabId: Int): Unit = ChromeAction.enable(tabId).await()
	suspend fun enable(): Unit = ChromeAction.enable().await()

	/**
	 * Gets the background color of the action.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun getBadgeBackgroundColor(details: TabDetails): ColorArray = ChromeAction.getBadgeBackgroundColor(details).await()

	/**
	 * Gets the badge text of the action. If no tab is specified, the non-tab-specific badge text is returned. If {@link declarativeNetRequest.ExtensionActionOptions.displayActionCountAsBadgeText displayActionCountAsBadgeText} is enabled, a placeholder text will be returned unless the {@link runtime.ManifestPermissions declarativeNetRequestFeedback} permission is present or tab-specific badge text was provided.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun getBadgeText(details: TabDetails): String = ChromeAction.getBadgeText(details).await()

	/**
	 * Gets the text color of the action.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 110
	 */
	suspend fun getBadgeTextColor(details: TabDetails): ColorArray = ChromeAction.getBadgeTextColor(details).await()

	/**
	 * Gets the html document set as the popup for this action.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun getPopup(details: TabDetails): String = ChromeAction.getPopup(details).await()

	/**
	 * Gets the title of the action.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun getTitle(details: TabDetails): String = ChromeAction.getTitle(details).await()

	/**
	 * Returns the user-specified settings relating to an extension's action.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 91
	 */
	suspend fun getUserSettings(): UserSettings = ChromeAction.getUserSettings().await()

	/**
	 * Indicates whether the extension action is enabled for a tab (or globally if no `tabId` is provided). Actions enabled using only {@link declarativeContent} always return false.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 110
	 */
	suspend fun isEnabled(tabId: Int): Boolean = ChromeAction.isEnabled(tabId).await()
	suspend fun isEnabled(): Boolean = ChromeAction.isEnabled().await()

	/**
	 * Opens the extension's popup. Between Chrome 118 and Chrome 126, this is only available to policy installed extensions.
	 *
	 * @param options Specifies options for opening the popup.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 127
	 */
	suspend fun openPopup(options: OpenPopupOptions)  = ChromeAction.openPopup(options).await()
	suspend fun openPopup()  = ChromeAction.openPopup().await()

	/**
	 * Sets the background color for the badge.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun setBadgeBackgroundColor(details: BadgeColorDetails): Unit = ChromeAction.setBadgeBackgroundColor(details).await()

	/**
	 * Sets the badge text for the action. The badge is displayed on top of the icon.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun setBadgeText(details: BadgeTextDetails): Unit = ChromeAction.setBadgeText(details).await()

	/**
	 * Sets the text color for the badge.
	 *
	 * Can return its result via Promise.
	 * @since Chrome 110
	 */
	suspend fun setBadgeTextColor(details: BadgeColorDetails): Unit = ChromeAction.setBadgeTextColor(details).await()

	/**
	 * Sets the icon for the action. The icon can be specified either as the path to an image file or as the pixel data from a canvas element, or as dictionary of either one of those. Either the path or the imageData property must be specified.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun setIcon(details: TabIconDetails): Unit = ChromeAction.setIcon(details).await()

	/**
	 * Sets the html document to be opened as a popup when the user clicks on the action's icon.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun setPopup(details: PopupDetails): Unit = ChromeAction.setPopup(details).await()

	/**
	 * Sets the title of the action. This shows up in the tooltip.
	 *
	 * Can return its result via Promise.
	 */
	suspend fun setTitle(details: TitleDetails): Unit = ChromeAction.setTitle(details).await()

	/** Fired when an action icon is clicked. This event will not fire if the action has a popup. */
	val onClicked: Event<(tab: Tab) -> Unit> by ChromeAction::onClicked

	/**
	 * Fired when user-specified settings relating to an extension's action change.
	 * @since Chrome 130
	 */
	val onUserSettingsChanged: Event<(change: UserSettingsChange) -> Unit> by ChromeAction::onUserSettingsChanged
}