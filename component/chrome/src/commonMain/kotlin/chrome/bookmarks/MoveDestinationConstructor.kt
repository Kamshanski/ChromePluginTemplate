package chrome.bookmarks

fun MoveDestination(
	/** The ID of the destination folder. */
	parentId: String?,
	index: Int? = null,
): MoveDestination =
	js("{}").unsafeCast<MoveDestination>().apply {
		this.parentId = parentId
		this.index = index
	}