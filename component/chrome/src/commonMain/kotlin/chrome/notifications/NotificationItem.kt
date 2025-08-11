package chrome.notifications

external interface NotificationItem {

	/** Additional details about this item. */
	var message: String

	/** Title of one item of a list notification. */
	var title: String
}

fun NotificationItem(
	/** Additional details about this item. */
	message: String,
	/** Title of one item of a list notification. */
	title: String,
): NotificationItem =
	js("{}").unsafeCast<NotificationItem>().apply {
		this.message = message
		this.title = title
	}