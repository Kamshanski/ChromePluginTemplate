@file:JsQualifier("chrome.notifications")

package chrome.notifications

external interface NotificationButton {

	/** @deprecated since Chrome 59. Button icons not visible for Mac OS X users. */
	@Deprecated("Deprecated since Chrome 59. The app icon mask is not visible for Mac OS X users.")
	var iconUrl: String?
	var title: String
}