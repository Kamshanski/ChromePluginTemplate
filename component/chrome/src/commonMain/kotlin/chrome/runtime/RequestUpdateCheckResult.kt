@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface RequestUpdateCheckResult {

	/** Result of the update check. */
	var status: RequestUpdateCheckStatus

	/** If an update is available, this contains the version of the available update. */
	var version: String?
}