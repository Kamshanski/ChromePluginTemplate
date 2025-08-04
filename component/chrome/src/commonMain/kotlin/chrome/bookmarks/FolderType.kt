package chrome.bookmarks

import chrome.bookmarks.constant.FolderTypeJsEnum

/**
 * Indicates the type of folder.
 * @since Chrome 134
 */
typealias FolderType = String

enum class FolderTypeEnum(private val valueProvider: FolderTypeJsEnum.() -> FolderType) {

	/** The folder whose contents is displayed at the top of the browser window. */
	BOOKMARKS_BAR({ BOOKMARKS_BAR }),

	/** Bookmarks which are displayed in the full list of bookmarks on all platforms. */
	OTHER({ OTHER }),

	/** Bookmarks generally available on the user's mobile devices, but modifiable by extension or in the bookmarks manager. */
	MOBILE({ MOBILE }),

	/** A top-level folder that may be present if the system administrator or the custodian of a supervised user has configured bookmarks. */
	MANAGED({ MANAGED });

	val value: FolderType get() = valueProvider(FolderTypeJsEnum)

	companion object {

		fun enumValueOf(value: FolderType): FolderTypeEnum = valueOf(value)
	}
}