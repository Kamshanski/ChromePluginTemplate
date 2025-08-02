@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

external interface MoveDestination {

	var parentId: String?
	var index: Int?
}