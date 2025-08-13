package chrome.bookmarks

external interface MoveDestination {

	var parentId: String?
	var index: Int?
}

fun MoveDestination(
	/** The ID of the destination folder. */
	parentId: String?,
	index: Int? = null,
): MoveDestination =
	js("{}").unsafeCast<MoveDestination>().apply {
		this.parentId = parentId
		this.index = index
	}