package chrome.bookmarks

external interface UpdateChanges {

	var title: String?
	var url: String?
}

fun UpdateChanges(
	/** The new title of the bookmark. */
	title: String? = null,
	/** The new URL of the bookmark. */
	url: String? = null,
): UpdateChanges =
	js("{}").unsafeCast<UpdateChanges>().apply {
		this.title = title
		this.url = url
	}