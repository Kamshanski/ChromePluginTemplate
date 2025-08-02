@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface OnDetachedInfo {

	var oldPosition: Int
	var oldWindowId: Int
}