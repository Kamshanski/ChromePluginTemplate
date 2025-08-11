package chrome.bookmarks

/** Object passed to the create() function. */
external interface CreateDetails {

	var index: Int?

	/** Defaults to the Other Bookmarks folder. */
	var parentId: String?
	var title: String?
	var url: String?
}

fun CreateDetails(
	/** Defaults to the Other Bookmarks folder. */
	title: String?,
	url: String? = null,
	parentId: String? = null,
	index: Int? = null,
): CreateDetails =
	js("{}").unsafeCast<CreateDetails>().apply {
		this.parentId = parentId
		this.index = index
		this.title = title
		this.url = url
	}