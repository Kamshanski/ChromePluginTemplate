@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

external interface RemoveInfo {

	var parentId: String
	var index: Double

	/** @since Chrome 48 */
	var node: BookmarkTreeNode
}