package chrome.action

/** @since Chrome 130 */
external interface UserSettingsChange {

	/** Whether the extension's action icon is visible on browser windows' top-level toolbar (i.e., whether the extension has been 'pinned' by the user). */
	var isOnToolbar: Boolean?
}