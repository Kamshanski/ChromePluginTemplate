package dev.kamshanski.chrome.component.chrome.notifications

import chrome.events.Event
import chrome.notifications.ChromeNotifications
import chrome.notifications.NotificationCreateOptions
import chrome.notifications.NotificationOptions
import chrome.notifications.PermissionLevel
import kotlinx.coroutines.await
import kotlin.js.Json

/** @see ChromeNotifications */
interface KChromeNotifications {

	companion object : KChromeNotifications {

		/** @see ChromeNotifications.onButtonClicked */
		override val onButtonClicked: Event<(notificationId: String, buttonIndex: Int) -> Unit> by ChromeNotifications::onButtonClicked

		/** @see ChromeNotifications.onClicked */
		override val onClicked: Event<(notificationId: String) -> Unit> by ChromeNotifications::onClicked

		/** @see ChromeNotifications.onClosed */
		override val onClosed: Event<(notificationId: String, byUser: Boolean) -> Unit> by ChromeNotifications::onClosed

		/** @see ChromeNotifications.onPermissionLevelChanged */
		override val onPermissionLevelChanged: Event<(level: PermissionLevel) -> Unit> by ChromeNotifications::onPermissionLevelChanged

		/** @see ChromeNotifications.onShowSettings */
		override val onShowSettings: Event<() -> Unit> by ChromeNotifications::onShowSettings

		/** @see ChromeNotifications.clear */
		override suspend fun clear(notificationId: String): Boolean = ChromeNotifications.clear(notificationId).await()

		/** @see ChromeNotifications.create */
		override suspend fun create(notificationId: String, options: NotificationCreateOptions): String = ChromeNotifications.create(notificationId, options).await()

		/** @see ChromeNotifications.create */
		override suspend fun create(options: NotificationCreateOptions): String = ChromeNotifications.create(options).await()

		// TODO check if it can be replaced with JsReadonlyArray<String>. As in TS it is { [key: string]: true }>
		/** @see ChromeNotifications.getAll */
		override suspend fun getAll(): Json = ChromeNotifications.getAll().await()

		/** @see ChromeNotifications.getPermissionLevel */
		override suspend fun getPermissionLevel(): PermissionLevel = ChromeNotifications.getPermissionLevel().await()

		/** @see ChromeNotifications.update */
		override suspend fun update(notificationId: String, options: NotificationOptions): Boolean = ChromeNotifications.update(notificationId, options).await()
	}

	/** @see ChromeNotifications.onButtonClicked */
	val onButtonClicked: Event<(notificationId: String, buttonIndex: Int) -> Unit>

	/** @see ChromeNotifications.onClicked */
	val onClicked: Event<(notificationId: String) -> Unit>

	/** @see ChromeNotifications.onClosed */
	val onClosed: Event<(notificationId: String, byUser: Boolean) -> Unit>

	/** @see ChromeNotifications.onPermissionLevelChanged */
	val onPermissionLevelChanged: Event<(level: PermissionLevel) -> Unit>

	/** @see ChromeNotifications.onShowSettings */
	val onShowSettings: Event<() -> Unit>

	/** @see ChromeNotifications.clear */
	suspend fun clear(notificationId: String): Boolean

	/** @see ChromeNotifications.create */
	suspend fun create(notificationId: String, options: NotificationCreateOptions): String

	/** @see ChromeNotifications.create */
	suspend fun create(options: NotificationCreateOptions): String

	// TODO check if it can be replaced with JsReadonlyArray<String>. As in TS it is { [key: string]: true }>
	/** @see ChromeNotifications.getAll */
	suspend fun getAll(): Json

	/** @see ChromeNotifications.getPermissionLevel */
	suspend fun getPermissionLevel(): PermissionLevel

	/** @see ChromeNotifications.update */
	suspend fun update(notificationId: String, options: NotificationOptions): Boolean
}