package dev.kamshanski.chrome.component.chrome.notifications

import chrome.notifications.NotificationButton
import chrome.notifications.NotificationCreateOptions
import chrome.notifications.NotificationItem
import chrome.notifications.NotificationOptions
import chrome.notifications.TemplateType
import kotlin.js.collections.JsReadonlyArray

/**
 * @see chrome.notifications.ChromeNotifications.create
 * @see NotificationCreateOptions
 */
suspend fun KChromeNotifications.create(
	notificationId: String,
	appIconMaskUrl: String? = null,
	buttons: JsReadonlyArray<NotificationButton>? = null,
	contextMessage: String? = null,
	eventTime: Number? = null,
	iconUrl: String,
	imageUrl: String? = null,
	isClickable: Boolean? = null,
	items: JsReadonlyArray<NotificationItem>? = null,
	message: String,
	priority: Double? = null,
	progress: Double? = null,
	requireInteraction: Boolean? = null,
	silent: Boolean? = null,
	title: String,
	type: TemplateType,
): String =
	create(
		notificationId = notificationId,
		options = NotificationCreateOptions(
			appIconMaskUrl = appIconMaskUrl,
			buttons = buttons,
			contextMessage = contextMessage,
			eventTime = eventTime,
			iconUrl = iconUrl,
			imageUrl = imageUrl,
			isClickable = isClickable,
			items = items,
			message = message,
			priority = priority,
			progress = progress,
			requireInteraction = requireInteraction,
			silent = silent,
			title = title,
			type = type,
		)
	)

/**
 * @see chrome.notifications.ChromeNotifications.create
 * @see NotificationCreateOptions
 */
suspend fun KChromeNotifications.create(
	appIconMaskUrl: String? = null,
	buttons: JsReadonlyArray<NotificationButton>? = null,
	contextMessage: String? = null,
	eventTime: Number? = null,
	iconUrl: String,
	imageUrl: String? = null,
	isClickable: Boolean? = null,
	items: JsReadonlyArray<NotificationItem>? = null,
	message: String,
	priority: Double? = null,
	progress: Double? = null,
	requireInteraction: Boolean? = null,
	silent: Boolean? = null,
	title: String,
	type: TemplateType,
): String =
	create(
		options = NotificationCreateOptions(
			appIconMaskUrl = appIconMaskUrl,
			buttons = buttons,
			contextMessage = contextMessage,
			eventTime = eventTime,
			iconUrl = iconUrl,
			imageUrl = imageUrl,
			isClickable = isClickable,
			items = items,
			message = message,
			priority = priority,
			progress = progress,
			requireInteraction = requireInteraction,
			silent = silent,
			title = title,
			type = type,
		)
	)

/**
 * @see chrome.notifications.ChromeNotifications.update
 * @see NotificationOptions
 */
suspend fun KChromeNotifications.update(
	notificationId: String,
	appIconMaskUrl: String? = null,
	buttons: JsReadonlyArray<NotificationButton>? = null,
	contextMessage: String? = null,
	eventTime: Number? = null,
	iconUrl: String? = null,
	imageUrl: String? = null,
	isClickable: Boolean? = null,
	items: JsReadonlyArray<NotificationItem>? = null,
	message: String? = null,
	priority: Double? = null,
	progress: Double? = null,
	requireInteraction: Boolean? = null,
	silent: Boolean? = null,
	title: String? = null,
	type: TemplateType? = null,
): Boolean =
	update(
		notificationId = notificationId,
		options = NotificationOptions(
			appIconMaskUrl = appIconMaskUrl,
			buttons = buttons,
			contextMessage = contextMessage,
			eventTime = eventTime,
			iconUrl = iconUrl,
			imageUrl = imageUrl,
			isClickable = isClickable,
			items = items,
			message = message,
			priority = priority,
			progress = progress,
			requireInteraction = requireInteraction,
			silent = silent,
			title = title,
			type = type,
		)
	)