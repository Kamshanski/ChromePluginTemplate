@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

external interface MoveInfo {

	var parentId: String
	var index: Double
	var oldParentId: String
	var oldIndex: Double
}