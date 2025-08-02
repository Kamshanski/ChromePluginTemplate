package chrome.bookmarks

/**
 * Indicates the type of folder.
 * @since Chrome 134
 */
enum class FolderType(val value: String) {

	/** The folder whose contents is displayed at the top of the browser window. */
	BOOKMARKS_BAR(value = "bookmarks-bar"),

	/** Bookmarks which are displayed in the full list of bookmarks on all platforms. */
	OTHER(value = "other"),

	/** Bookmarks generally available on the user's mobile devices, but modifiable by extension or in the bookmarks manager. */
	MOBILE(value = "mobile"),

	/** A top-level folder that may be present if the system administrator or the custodian of a supervised user has configured bookmarks. */
	MANAGED(value = "managed"),
	;

	companion object {

		fun byStringOrNull(value: String): FolderType? = entries.firstOrNull { it.value == value }
		fun byString(value: String): FolderType = byStringOrNull(value) ?: throw NoSuchElementException("FolderType $value")
	}
}