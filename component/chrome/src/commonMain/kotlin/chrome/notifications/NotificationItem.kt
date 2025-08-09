@file:JsQualifier("chrome.notifications")

package chrome.notifications

external interface NotificationItem {

	/** Additional details about this item. */
	var message: String

	/** Title of one item of a list notification. */
	var title: String
}