@file:JsQualifier("chrome.action")

package chrome.action

/**
 * The collection of user-specified settings relating to an extension's action.
 * @since Chrome 91
 */
external interface UserSettings {

	/** Whether the extension's action icon is visible on browser windows' top-level toolbar (i.e., whether the extension has been 'pinned' by the user). */
	var isOnToolbar: Boolean
}