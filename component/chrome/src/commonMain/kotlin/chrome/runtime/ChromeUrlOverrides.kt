@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface ChromeUrlOverrides {

	var bookmarks: String?
	var history: String?
	var newtab: String?
}