package dev.kamshanski.chrome.component.chrome.notifications

import chrome.events.Event
import chrome.notifications.ChromeNotifications
import chrome.notifications.NotificationCreateOptions
import chrome.notifications.NotificationOptions
import chrome.notifications.PermissionLevel
import kotlinx.coroutines.await
import kotlin.js.Json

@Suppress("unused")
interface KChromeNotifications {

	companion object : KChromeNotifications {

		override val onButtonClicked: Event<(notificationId: String, buttonIndex: Int) -> Unit> by ChromeNotifications::onButtonClicked

		override val onClicked: Event<(notificationId: String) -> Unit> by ChromeNotifications::onClicked

		override val onClosed: Event<(notificationId: String, byUser: Boolean) -> Unit> by ChromeNotifications::onClosed

		override val onPermissionLevelChanged: Event<(level: PermissionLevel) -> Unit> by ChromeNotifications::onPermissionLevelChanged

		override val onShowSettings: Event<() -> Unit> by ChromeNotifications::onShowSettings

		override suspend fun clear(notificationId: String): Boolean = ChromeNotifications.clear(notificationId).await()

		override suspend fun create(notificationId: String, options: NotificationCreateOptions): String = ChromeNotifications.create(notificationId, options).await()
		override suspend fun create(options: NotificationCreateOptions): String = ChromeNotifications.create(options).await()

		// TODO check if it can be replaced with JsReadonlyArray<String>. As in TS it is { [key: string]: true }>
		override suspend fun getAll(): Json = ChromeNotifications.getAll().await()

		override suspend fun getPermissionLevel(): PermissionLevel = ChromeNotifications.getPermissionLevel().await()

		override suspend fun update(notificationId: String, options: NotificationOptions): Boolean = ChromeNotifications.update(notificationId, options).await()
	}

	val onButtonClicked: Event<(notificationId: String, buttonIndex: Int) -> Unit>

	val onClicked: Event<(notificationId: String) -> Unit>

	val onClosed: Event<(notificationId: String, byUser: Boolean) -> Unit>

	val onPermissionLevelChanged: Event<(level: PermissionLevel) -> Unit>

	val onShowSettings: Event<() -> Unit>

	suspend fun clear(notificationId: String): Boolean

	suspend fun create(notificationId: String, options: NotificationCreateOptions): String
	suspend fun create(options: NotificationCreateOptions): String

	// TODO check if it can be replaced with JsReadonlyArray<String>. As in TS it is { [key: string]: true }>
	suspend fun getAll(): Json

	suspend fun getPermissionLevel(): PermissionLevel

	suspend fun update(notificationId: String, options: NotificationOptions): Boolean
}