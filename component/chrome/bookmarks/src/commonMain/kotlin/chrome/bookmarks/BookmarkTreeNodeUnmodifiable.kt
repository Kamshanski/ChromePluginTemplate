@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

/**
 * Indicates the reason why this node is unmodifiable. The `managed` value indicates that this node was configured by the system administrator. Omitted if the node can be modified by the user and the extension (default).
 * @since Chrome 44
 */
sealed external interface BookmarkTreeNodeUnmodifiable {

	companion object {

		val MANAGED: BookmarkTreeNodeUnmodifiable
	}
}