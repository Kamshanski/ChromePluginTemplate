@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

external interface MoveInfo {

	var parentId: String
	var index: Int
	var oldParentId: String
	var oldIndex: Int
}