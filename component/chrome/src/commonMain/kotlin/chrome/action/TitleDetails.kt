@file:JsQualifier("chrome.action")

package chrome.action

external interface TitleDetails {

	/** The string the action should display when moused over. */
	var title: String

	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	var tabId: Int?
}