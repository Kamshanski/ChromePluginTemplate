package chrome.bookmarks

/**
 * Indicates the reason why this node is unmodifiable. The `managed` value indicates that this node was configured by the system administrator. Omitted if the node can be modified by the user and the extension (default).
 * @since Chrome 44
 */
enum class BookmarkTreeNodeUnmodifiable(val value: String) {

	MANAGED("managed"),
	;

	companion object {

		fun byStringOrNull(value: String): BookmarkTreeNodeUnmodifiable? = BookmarkTreeNodeUnmodifiable.entries.firstOrNull { it.value == value }
		fun byString(value: String): BookmarkTreeNodeUnmodifiable = byStringOrNull(value) ?: throw NoSuchElementException("BookmarkTreeNodeUnmodifiable $value")
	}
}