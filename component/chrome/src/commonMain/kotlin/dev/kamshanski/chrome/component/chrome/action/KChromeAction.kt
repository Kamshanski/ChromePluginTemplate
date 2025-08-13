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
 * @see ChromeAction
 */
@Suppress("unused")
interface KChromeAction {

	companion object : KChromeAction {

		override val onClicked: Event<(tab: Tab) -> Unit> by ChromeAction::onClicked

		override val onUserSettingsChanged: Event<(change: UserSettingsChange) -> Unit> by ChromeAction::onUserSettingsChanged

		override suspend fun disable(tabId: Int): Unit = ChromeAction.disable(tabId).await()
		override suspend fun disable(): Unit = ChromeAction.disable().await()

		override suspend fun enable(tabId: Int): Unit = ChromeAction.enable(tabId).await()
		override suspend fun enable(): Unit = ChromeAction.enable().await()

		override suspend fun getBadgeBackgroundColor(details: TabDetails): ColorArray = ChromeAction.getBadgeBackgroundColor(details).await()

		override suspend fun getBadgeText(details: TabDetails): String = ChromeAction.getBadgeText(details).await()

		override suspend fun getBadgeTextColor(details: TabDetails): ColorArray = ChromeAction.getBadgeTextColor(details).await()

		override suspend fun getPopup(details: TabDetails): String = ChromeAction.getPopup(details).await()

		override suspend fun getTitle(details: TabDetails): String = ChromeAction.getTitle(details).await()

		override suspend fun getUserSettings(): UserSettings = ChromeAction.getUserSettings().await()

		override suspend fun isEnabled(tabId: Int): Boolean = ChromeAction.isEnabled(tabId).await()
		override suspend fun isEnabled(): Boolean = ChromeAction.isEnabled().await()

		override suspend fun openPopup(options: OpenPopupOptions) = ChromeAction.openPopup(options).await()
		override suspend fun openPopup() = ChromeAction.openPopup().await()

		override suspend fun setBadgeBackgroundColor(details: BadgeColorDetails): Unit = ChromeAction.setBadgeBackgroundColor(details).await()

		override suspend fun setBadgeText(details: BadgeTextDetails): Unit = ChromeAction.setBadgeText(details).await()

		override suspend fun setBadgeTextColor(details: BadgeColorDetails): Unit = ChromeAction.setBadgeTextColor(details).await()

		override suspend fun setIcon(details: TabIconDetails): Unit = ChromeAction.setIcon(details).await()

		override suspend fun setPopup(details: PopupDetails): Unit = ChromeAction.setPopup(details).await()

		override suspend fun setTitle(details: TitleDetails): Unit = ChromeAction.setTitle(details).await()
	}

	val onClicked: Event<(tab: Tab) -> Unit>

	val onUserSettingsChanged: Event<(change: UserSettingsChange) -> Unit>

	suspend fun disable(tabId: Int)

	suspend fun disable()

	suspend fun enable(tabId: Int)
	suspend fun enable()

	suspend fun getBadgeBackgroundColor(details: TabDetails): ColorArray

	suspend fun getBadgeText(details: TabDetails): String

	suspend fun getBadgeTextColor(details: TabDetails): ColorArray

	suspend fun getPopup(details: TabDetails): String

	suspend fun getTitle(details: TabDetails): String

	suspend fun getUserSettings(): UserSettings

	suspend fun isEnabled(tabId: Int): Boolean
	suspend fun isEnabled(): Boolean

	suspend fun openPopup(options: OpenPopupOptions)
	suspend fun openPopup()

	suspend fun setBadgeBackgroundColor(details: BadgeColorDetails)

	suspend fun setBadgeText(details: BadgeTextDetails)

	suspend fun setBadgeTextColor(details: BadgeColorDetails)

	suspend fun setIcon(details: TabIconDetails)

	suspend fun setPopup(details: PopupDetails)

	suspend fun setTitle(details: TitleDetails)
}