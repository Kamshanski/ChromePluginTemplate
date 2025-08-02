package chrome.bookmarks

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