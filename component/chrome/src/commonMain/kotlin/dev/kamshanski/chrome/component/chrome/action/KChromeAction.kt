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

/** @see ChromeAction */
interface KChromeAction {

	companion object : KChromeAction {

		/** @see ChromeAction.onClicked */
		override val onClicked: Event<(tab: Tab) -> Unit> by ChromeAction::onClicked

		/** @see ChromeAction.onUserSettingsChanged */
		override val onUserSettingsChanged: Event<(change: UserSettingsChange) -> Unit> by ChromeAction::onUserSettingsChanged

		/** @see ChromeAction.disable */
		override suspend fun disable(tabId: Int): Unit = ChromeAction.disable(tabId).await()

		/** @see ChromeAction.disable */
		override suspend fun disable(): Unit = ChromeAction.disable().await()

		/** @see ChromeAction.enable */
		override suspend fun enable(tabId: Int): Unit = ChromeAction.enable(tabId).await()

		/** @see ChromeAction.enable */
		override suspend fun enable(): Unit = ChromeAction.enable().await()

		/** @see ChromeAction.getBadgeBackgroundColor */
		override suspend fun getBadgeBackgroundColor(details: TabDetails): ColorArray = ChromeAction.getBadgeBackgroundColor(details).await()

		/** @see ChromeAction.getBadgeText */
		override suspend fun getBadgeText(details: TabDetails): String = ChromeAction.getBadgeText(details).await()

		/** @see ChromeAction.getBadgeTextColor */
		override suspend fun getBadgeTextColor(details: TabDetails): ColorArray = ChromeAction.getBadgeTextColor(details).await()

		/** @see ChromeAction.getPopup */
		override suspend fun getPopup(details: TabDetails): String = ChromeAction.getPopup(details).await()

		/** @see ChromeAction.getTitle */
		override suspend fun getTitle(details: TabDetails): String = ChromeAction.getTitle(details).await()

		/** @see ChromeAction.getUserSettings */
		override suspend fun getUserSettings(): UserSettings = ChromeAction.getUserSettings().await()

		/** @see ChromeAction.isEnabled */
		override suspend fun isEnabled(tabId: Int): Boolean = ChromeAction.isEnabled(tabId).await()

		/** @see ChromeAction.isEnabled */
		override suspend fun isEnabled(): Boolean = ChromeAction.isEnabled().await()

		/** @see ChromeAction.openPopup */
		override suspend fun openPopup(options: OpenPopupOptions) = ChromeAction.openPopup(options).await()

		/** @see ChromeAction.openPopup */
		override suspend fun openPopup() = ChromeAction.openPopup().await()

		/** @see ChromeAction.setBadgeBackgroundColor */
		override suspend fun setBadgeBackgroundColor(details: BadgeColorDetails): Unit = ChromeAction.setBadgeBackgroundColor(details).await()

		/** @see ChromeAction.setBadgeText */
		override suspend fun setBadgeText(details: BadgeTextDetails): Unit = ChromeAction.setBadgeText(details).await()

		/** @see ChromeAction.setBadgeTextColor */
		override suspend fun setBadgeTextColor(details: BadgeColorDetails): Unit = ChromeAction.setBadgeTextColor(details).await()

		/** @see ChromeAction.setIcon */
		override suspend fun setIcon(details: TabIconDetails): Unit = ChromeAction.setIcon(details).await()

		/** @see ChromeAction.setPopup */
		override suspend fun setPopup(details: PopupDetails): Unit = ChromeAction.setPopup(details).await()

		/** @see ChromeAction.setTitle */
		override suspend fun setTitle(details: TitleDetails): Unit = ChromeAction.setTitle(details).await()
	}

	/** @see ChromeAction.onClicked */
	val onClicked: Event<(tab: Tab) -> Unit>

	/** @see ChromeAction.onUserSettingsChanged */
	val onUserSettingsChanged: Event<(change: UserSettingsChange) -> Unit>

	/** @see ChromeAction.disable */
	suspend fun disable(tabId: Int)

	/** @see ChromeAction.disable */
	suspend fun disable()

	/** @see ChromeAction.enable */
	suspend fun enable(tabId: Int)

	/** @see ChromeAction.enable */
	suspend fun enable()

	/** @see ChromeAction.getBadgeBackgroundColor */
	suspend fun getBadgeBackgroundColor(details: TabDetails): ColorArray

	/** @see ChromeAction.getBadgeText */
	suspend fun getBadgeText(details: TabDetails): String

	/** @see ChromeAction.getBadgeTextColor */
	suspend fun getBadgeTextColor(details: TabDetails): ColorArray

	/** @see ChromeAction.getPopup */
	suspend fun getPopup(details: TabDetails): String

	/** @see ChromeAction.getTitle */
	suspend fun getTitle(details: TabDetails): String

	/** @see ChromeAction.getUserSettings */
	suspend fun getUserSettings(): UserSettings

	/** @see ChromeAction.isEnabled */
	suspend fun isEnabled(tabId: Int): Boolean

	/** @see ChromeAction.isEnabled */
	suspend fun isEnabled(): Boolean

	/** @see ChromeAction.openPopup */
	suspend fun openPopup(options: OpenPopupOptions)

	/** @see ChromeAction.openPopup */
	suspend fun openPopup()

	/** @see ChromeAction.setBadgeBackgroundColor */
	suspend fun setBadgeBackgroundColor(details: BadgeColorDetails)

	/** @see ChromeAction.setBadgeText */
	suspend fun setBadgeText(details: BadgeTextDetails)

	/** @see ChromeAction.setBadgeTextColor */
	suspend fun setBadgeTextColor(details: BadgeColorDetails)

	/** @see ChromeAction.setIcon */
	suspend fun setIcon(details: TabIconDetails)

	/** @see ChromeAction.setPopup */
	suspend fun setPopup(details: PopupDetails)

	/** @see ChromeAction.setTitle */
	suspend fun setTitle(details: TitleDetails)
}