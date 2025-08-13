package dev.kamshanski.chrome.component.chrome.bookmarks

import chrome.bookmarks.BookmarkTreeNode
import chrome.bookmarks.CreateDetails
import chrome.bookmarks.MoveDestination
import chrome.bookmarks.SearchQuery
import chrome.bookmarks.UpdateChanges

/**
 * @see chrome.bookmarks.ChromeBookmarks.create
 * @see CreateDetails
 */
suspend fun KChromeBookmarks.create(
	title: String?,
	url: String? = null,
	parentId: String? = null,
	index: Int? = null,
): BookmarkTreeNode = create(
	CreateDetails(
		title = title,
		url = url,
		parentId = parentId,
		index = index,
	)
)

/**
 * @see chrome.bookmarks.ChromeBookmarks.move
 * @see MoveDestination
 */
suspend fun KChromeBookmarks.move(
	id: String,
	parentId: String?,
	index: Int? = null,
): BookmarkTreeNode =
	move(
		id = id,
		destination = MoveDestination(
			parentId = parentId,
			index = index,
		)
	)

/**
 * @see chrome.bookmarks.ChromeBookmarks.search
 * @see BookmarkTreeNode
 */
suspend fun KChromeBookmarks.search(
	query: String? = null,
	url: String? = null,
	title: String? = null,
): List<BookmarkTreeNode> =
	search(
		SearchQuery(
			query = query,
			url = url,
			title = title,
		)
	)

/**
 * @see chrome.bookmarks.ChromeBookmarks.update
 * @see UpdateChanges
 */
suspend fun KChromeBookmarks.update(
	id: String,
	title: String? = null,
	url: String? = null,
): BookmarkTreeNode =
	update(
		id = id,
		UpdateChanges(
			title = title,
			url = url,
		)
	)