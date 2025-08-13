package chrome.notifications

import kotlin.js.Date
import kotlin.js.collections.JsReadonlyArray

external interface NotificationOptions {

	/**
	 * A URL to the app icon mask. URLs have the same restrictions as {@link notifications.NotificationOptions.iconUrl iconUrl}.
	 *
	 * The app icon mask should be in alpha channel, as only the alpha channel of the image will be considered.
	 * @deprecated since Chrome 59. The app icon mask is not visible for Mac OS X users.
	 */
	@Deprecated("Deprecated since Chrome 59. The app icon mask is not visible for Mac OS X users.")
	var appIconMaskUrl: String?

	/** Text and icons for up to two notification action buttons. */
	var buttons: JsReadonlyArray<NotificationButton>?

	/** Alternate notification content with a lower-weight font. */
	var contextMessage: String?

	/** A timestamp associated with the notification, in milliseconds past the epoch (e.g. `Date.now() + n`). */
	var eventTime: Number?

	/**
	 * A URL to the sender's avatar, app icon, or a thumbnail for image notifications.
	 *
	 * URLs can be a data URL, a blob URL, or a URL relative to a resource within this extension's .crx file
	 *
	 * **Note:** This value is required for the {@link notifications.create}() method.
	 */
	var iconUrl: String?

	/**
	 * A URL to the image thumbnail for image-type notifications. URLs have the same restrictions as {@link notifications.NotificationOptions.iconUrl iconUrl}.
	 * @deprecated since Chrome 59. The image is not visible for Mac OS X users.
	 */
	@Deprecated("Deprecated since Chrome 59. The app icon mask is not visible for Mac OS X users.")
	var imageUrl: String?

	/** @deprecated since Chrome 67. This UI hint is ignored as of Chrome 67 */
	@Deprecated("Deprecated since Chrome 67. This UI hint is ignored as of Chrome 67")
	var isClickable: Boolean?

	/** Items for multi-item notifications. Users on Mac OS X only see the first item. */
	var items: JsReadonlyArray<NotificationItem>?

	/**
	 * Main notification content.
	 *
	 * **Note:** This value is required for the {@link notifications.create}() method.
	 */
	var message: String?

	/** Priority ranges from -2 to 2. -2 is lowest priority. 2 is highest. Zero is default. On platforms that don't support a notification center (Windows, Linux & Mac), -2 and -1 result in an error as notifications with those priorities will not be shown at all. */
	var priority: Double?

	/** Current progress ranges from 0 to 100. */
	var progress: Double?

	/**
	 * Indicates that the notification should remain visible on screen until the user activates or dismisses the notification. This defaults to false.
	 * @since Chrome 50
	 */
	var requireInteraction: Boolean?

	/**
	 * Indicates that no sounds or vibrations should be made when the notification is being shown. This defaults to false.
	 * @since Chrome 70
	 */
	var silent: Boolean?

	/**
	 * Title of the notification (e.g. sender name for email).
	 *
	 * **Note:** This value is required for the {@link notifications.create}() method.
	 */
	var title: String?

	/** Which type of notification to display.
	 *
	 * **Note:** This value is required for the {@link notifications.create}() method.
	 */
	var type: TemplateType?
}

fun NotificationOptions(
	/**
	 * A URL to the app icon mask. URLs have the same restrictions as {@link notifications.NotificationOptions.iconUrl iconUrl}.
	 *
	 * The app icon mask should be in alpha channel, as only the alpha channel of the image will be considered.
	 * @deprecated since Chrome 59. The app icon mask is not visible for Mac OS X users.
	 */
	appIconMaskUrl: String? = null,
	/** Text and icons for up to two notification action buttons. */
	buttons: JsReadonlyArray<NotificationButton>? = null,
	/** Alternate notification content with a lower-weight font. */
	contextMessage: String? = null,
	/** A timestamp associated with the notification, in milliseconds past the epoch (e.g. `Date.now() + n`). */
	eventTime: Number? = null,
	/**
	 * A URL to the sender's avatar, app icon, or a thumbnail for image notifications.
	 *
	 * URLs can be a data URL, a blob URL, or a URL relative to a resource within this extension's .crx file
	 *
	 * **Note:** This value is required for the {@link notifications.create}() method.
	 */
	iconUrl: String? = null,
	/**
	 * A URL to the image thumbnail for image-type notifications. URLs have the same restrictions as {@link notifications.NotificationOptions.iconUrl iconUrl}.
	 * @deprecated since Chrome 59. The image is not visible for Mac OS X users.
	 */
	imageUrl: String? = null,
	/** @deprecated since Chrome 67. This UI hint is ignored as of Chrome 67 */
	isClickable: Boolean? = null,
	/** Items for multi-item notifications. Users on Mac OS X only see the first item. */
	items: JsReadonlyArray<NotificationItem>? = null,
	/**
	 * Main notification content.
	 *
	 * **Note:** This value is required for the {@link notifications.create}() method.
	 */
	message: String? = null,
	/** Priority ranges from -2 to 2. -2 is lowest priority. 2 is highest. Zero is default. On platforms that don't support a notification center (Windows, Linux & Mac), -2 and -1 result in an error as notifications with those priorities will not be shown at all. */
	priority: Double? = null,
	/** Current progress ranges from 0 to 100. */
	progress: Double? = null,
	/**
	 * Indicates that the notification should remain visible on screen until the user activates or dismisses the notification. This defaults to false.
	 * @since Chrome 50
	 */
	requireInteraction: Boolean? = null,
	/**
	 * Indicates that no sounds or vibrations should be made when the notification is being shown. This defaults to false.
	 * @since Chrome 70
	 */
	silent: Boolean? = null,
	/**
	 * Title of the notification (e.g. sender name for email).
	 *
	 * **Note:** This value is required for the {@link notifications.create}() method.
	 */
	title: String? = null,
	/** Which type of notification to display.
	 *
	 * **Note:** This value is required for the {@link notifications.create}() method.
	 */
	type: TemplateType? = null,
): NotificationOptions =
	js("{}").unsafeCast<NotificationOptions>().apply {
		this.appIconMaskUrl = appIconMaskUrl
		this.buttons = buttons
		this.contextMessage = contextMessage
		this.eventTime = eventTime
		this.iconUrl = iconUrl
		this.imageUrl = imageUrl
		this.isClickable = isClickable
		this.items = items
		this.message = message
		this.priority = priority
		this.progress = progress
		this.requireInteraction = requireInteraction
		this.silent = silent
		this.title = title
		this.type = type
	}