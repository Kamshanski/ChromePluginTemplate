@file:JsQualifier("chrome")

package chrome.notifications

import chrome.events.Event
import kotlin.js.Json
import kotlin.js.Promise

/**
 * Use the `chrome.notifications` API to create rich notifications using templates and show these notifications to users in the system tray.
 *
 * Permissions: "notifications"
 */
@Suppress("unused")
@JsName("notifications")
external object ChromeNotifications {

	/**
	 * Clears the specified notification.
	 * @param notificationId The id of the notification to be cleared. This is returned by {@link notifications.create} method.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	fun clear(notificationId: String): Promise<Boolean>
	fun clear(notificationId: String, callback: (wasCleared: Boolean) -> Unit)

	/**
	 * Creates and displays a notification.
	 * @param notificationId Identifier of the notification. If not set or empty, an ID will automatically be generated. If it matches an existing notification, this method first clears that notification before proceeding with the create operation. The identifier may not be longer than 500 characters.
	 *
	 * The `notificationId` parameter is required before Chrome 42.
	 * @param options Contents of the notification.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	fun create(notificationId: String, options: NotificationCreateOptions): Promise<String>
	fun create(options: NotificationCreateOptions): Promise<String>
	fun create(notificationId: String, options: NotificationCreateOptions, callback: (notificationId: String) -> Unit)
	fun create(options: NotificationCreateOptions, callback: (notificationId: String) -> Unit)

	/**
	 * Retrieves all the notifications of this app or extension.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	// TODO check if it can be replaced with JsReadonlyArray<String>. As in TS it is Promise<{ [key: string]: true }>
	fun getAll(): Promise<Json>
	fun getAll(callback: (notifications: Json) -> Unit)

	/**
	 * Retrieves whether the user has enabled notifications from this app or extension.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	fun getPermissionLevel(): Promise<PermissionLevel>
	fun getPermissionLevel(callback: (level: PermissionLevel) -> Unit)

	/**
	 * Updates an existing notification.
	 * @param notificationId The id of the notification to be updated. This is returned by {@link notifications.create} method.
	 * @param options Contents of the notification to update to.
	 *
	 * Can return its result via Promise since Chrome 116
	 */
	fun update(notificationId: String, options: NotificationOptions): Promise<Boolean>
	fun update(notificationId: String, options: NotificationOptions, callback: (wasUpdated: Boolean) -> Unit)

	/** The user pressed a button in the notification. */
	val onButtonClicked: Event<(notificationId: String, buttonIndex: Int) -> Unit>

	/** The user clicked in a non-button area of the notification. */
	val onClicked: Event<(notificationId: String) -> Unit>

	/** The notification closed, either by the system or by user action. */
	val onClosed: Event<(notificationId: String, byUser: Boolean) -> Unit>

	/** The user changes the permission level. As of Chrome 47, only ChromeOS has UI that dispatches this event. */
	val onPermissionLevelChanged: Event<(level: PermissionLevel) -> Unit>

	/**
	 * The user clicked on a link for the app's notification settings. As of Chrome 47, only ChromeOS has UI that dispatches this event. As of Chrome 65, that UI has been removed from ChromeOS, too.
	 * @deprecated since Chrome 65. Custom notification settings button is no longer supported.
	 */
	@Deprecated("Deprecated since Chrome 65. Custom notification settings button is no longer supported.")
	val onShowSettings: Event<() -> Unit>
}