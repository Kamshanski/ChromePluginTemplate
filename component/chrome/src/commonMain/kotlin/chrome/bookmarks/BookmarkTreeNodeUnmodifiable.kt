package chrome.bookmarks

import chrome.bookmarks.constant.BookmarkTreeNodeUnmodifiableJsEnum

/**
 * Indicates the reason why this node is unmodifiable. The `managed` value indicates that this node was configured by the system administrator. Omitted if the node can be modified by the user and the extension (default).
 * @since Chrome 44
 */
typealias BookmarkTreeNodeUnmodifiable = String

enum class BookmarkTreeNodeUnmodifiableEnum(private val valueProvider: BookmarkTreeNodeUnmodifiableJsEnum.() -> BookmarkTreeNodeUnmodifiable) {

	MANAGED({ MANAGED });

	val value: BookmarkTreeNodeUnmodifiable get() = valueProvider(BookmarkTreeNodeUnmodifiableJsEnum)

	companion object {

		fun enumValueOf(value: BookmarkTreeNodeUnmodifiable): BookmarkTreeNodeUnmodifiableEnum = valueOf(value)
	}
}