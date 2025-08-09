package dev.kamshanski.chrome.component.chrome.notifications

import chrome.events.Event
import chrome.notifications.ChromeNotifications
import chrome.notifications.NotificationCreateOptions
import chrome.notifications.NotificationOptions
import chrome.notifications.PermissionLevel
import kotlinx.coroutines.await
import kotlin.js.Json

/**
 * Use the `chrome.notifications` API to create rich notifications using templates and show these notifications to users in the system tray.
 *
 * Permissions: "notifications"
 */
@Suppress("unused")
object ChromeCoroutinesNotifications {

	/**
	 * Clears the specified notification.
	 * @param notificationId The id of the notification to be cleared. This is returned by {@link notifications.create} method.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	suspend fun clear(notificationId: String): Boolean = ChromeNotifications.clear(notificationId).await()

	/**
	 * Creates and displays a notification.
	 * @param notificationId Identifier of the notification. If not set or empty, an ID will automatically be generated. If it matches an existing notification, this method first clears that notification before proceeding with the create operation. The identifier may not be longer than 500 characters.
	 *
	 * The `notificationId` parameter is required before Chrome 42.
	 * @param options Contents of the notification.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	suspend fun create(notificationId: String, options: NotificationCreateOptions): String = ChromeNotifications.create(notificationId, options).await()
	suspend fun create(options: NotificationCreateOptions): String = ChromeNotifications.create(options).await()

	/**
	 * Retrieves all the notifications of this app or extension.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	// TODO check if it can be replaced with JsReadonlyArray<String>. As in TS it is { [key: string]: true }>
	suspend fun getAll(): Json = ChromeNotifications.getAll().await()

	/**
	 * Retrieves whether the user has enabled notifications from this app or extension.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	suspend fun getPermissionLevel(): PermissionLevel = ChromeNotifications.getPermissionLevel().await()

	/**
	 * Updates an existing notification.
	 * @param notificationId The id of the notification to be updated. This is returned by {@link notifications.create} method.
	 * @param options Contents of the notification to update to.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	suspend fun update(notificationId: String, options: NotificationOptions): Boolean = ChromeNotifications.update(notificationId, options).await()

	/** The user pressed a button in the notification. */
	val onButtonClicked: Event<(notificationId: String, buttonIndex: Int) -> Unit> by ChromeNotifications::onButtonClicked

	/** The user clicked in a non-button area of the notification. */
	val onClicked: Event<(notificationId: String) -> Unit> by ChromeNotifications::onClicked

	/** The notification closed, either by the system or by user action. */
	val onClosed: Event<(notificationId: String, byUser: Boolean) -> Unit> by ChromeNotifications::onClosed

	/** The user changes the permission level. As of Chrome 47, only ChromeOS has UI that dispatches this event. */
	val onPermissionLevelChanged: Event<(level: PermissionLevel) -> Unit> by ChromeNotifications::onPermissionLevelChanged

	/**
	 * The user clicked on a link for the app's notification settings. As of Chrome 47, only ChromeOS has UI that dispatches this event. As of Chrome 65, that UI has been removed from ChromeOS, too.
	 * @deprecated since Chrome 65. Custom notification settings button is no longer supported.
	 */
	@Deprecated("Deprecated since Chrome 65. Custom notification settings button is no longer supported.")
	val onShowSettings: Event<() -> Unit> by ChromeNotifications::onShowSettings
}