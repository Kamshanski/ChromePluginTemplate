package dev.kamshanski.chrome.component.chrome.bookmarks

import chrome.bookmarks.BookmarkTreeNode
import chrome.bookmarks.ChangeInfo
import chrome.bookmarks.ChromeBookmarks
import chrome.bookmarks.CreateDetails
import chrome.bookmarks.MoveDestination
import chrome.bookmarks.MoveInfo
import chrome.bookmarks.RemoveInfo
import chrome.bookmarks.ReorderInfo
import chrome.bookmarks.SearchQuery
import chrome.bookmarks.UpdateChanges
import chrome.events.Event
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await

@Suppress("unused")
object KChromeBookmarks {

	/** Fired when a bookmark or folder changes. **Note:** Currently, only title and url changes trigger this.*/
	val onChanged: Event<(id: String, changeInfo: ChangeInfo) -> Unit> by ChromeBookmarks::onChanged

	/** Fired when the children of a folder have changed their order due to the order being sorted in the UI. This is not called as a result of a move(). */
	val onChildrenReordered: Event<(id: String, reorderInfo: ReorderInfo) -> Unit> by ChromeBookmarks::onChildrenReordered

	/** Fired when a bookmark or folder is created. */
	val onCreated: Event<(id: String, bookmark: BookmarkTreeNode) -> Unit> by ChromeBookmarks::onCreated

	/** Fired when a bookmark import session is begun. Expensive observers should ignore onCreated updates until onImportEnded is fired. Observers should still handle other notifications immediately. */
	val onImportBegan: Event<() -> Unit> by ChromeBookmarks::onImportBegan

	/** Fired when a bookmark import session is ended.  */
	val onImportEnded: Event<() -> Unit> by ChromeBookmarks::onImportEnded

	/** Fired when a bookmark or folder is moved to a different parent folder. */
	val onMoved: Event<(id: String, moveInfo: MoveInfo) -> Unit> by ChromeBookmarks::onMoved

	/** Fired when a bookmark or folder is removed. When a folder is removed recursively, a single notification is fired for the folder, and none for its contents. */
	val onRemoved: Event<(id: String, removeInfo: RemoveInfo) -> Unit> by ChromeBookmarks::onRemoved

	/**
	 * Creates a bookmark or folder under the specified parentId. If url is NULL or missing, it will be a folder.
	 *
	 * Suspend version enabled since Chrome 90.
	 */
	suspend fun create(bookmark: CreateDetails): BookmarkTreeNode =
		ChromeBookmarks.create(bookmark).await()

	/**
	 * Retrieves the entire Bookmarks hierarchy.
	 *
	 * Suspend version enabled since Chrome 90
	 */
	suspend fun getTree(): List<BookmarkTreeNode> {
		return ChromeBookmarks.getTree().await().asList()
	}

	/**
	 * Retrieves the specified BookmarkTreeNode(s).
	 * @param id A single string-valued id, or an array of string-valued ids
	 *
	 * Suspend version enabled since Chrome 90.
	 */
	suspend fun get(id: String): List<BookmarkTreeNode> =
		ChromeBookmarks.get(id).await().asList()

	/**
	 * Retrieves the specified BookmarkTreeNode(s).
	 * @param idList A single string-valued id, or an array of string-valued ids
	 *
	 * Suspend version enabled since Chrome 90.
	 */
	suspend fun get(
		idList: Array<String>
	): List<BookmarkTreeNode> =
		ChromeBookmarks.get(idList).await().asList()

	/**
	 * Retrieves the children of the specified BookmarkTreeNode id.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun getChildren(id: String): List<BookmarkTreeNode> =
		ChromeBookmarks.getChildren(id).await().asList()

	/**
	 * Retrieves the recently added bookmarks.
	 * @param numberOfItems The maximum number of items to return.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun getRecent(numberOfItems: Int): List<BookmarkTreeNode> =
		ChromeBookmarks.getRecent(numberOfItems).await().asList()

	/**
	 * Retrieves part of the Bookmarks hierarchy, starting at the specified node.
	 * @param id The ID of the root of the subtree to retrieve.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun getSubTree(id: String): List<BookmarkTreeNode> =
		ChromeBookmarks.getSubTree(id).await().asList()

	/**
	 * Moves the specified BookmarkTreeNode to the provided location.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun move(id: String, destination: MoveDestination): BookmarkTreeNode =
		ChromeBookmarks.move(id, destination).await()

	/**
	 * Removes a bookmark or an empty bookmark folder.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun remove(id: String) =
		ChromeBookmarks.remove(id).await()

	/**
	 * Recursively removes a bookmark folder.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun removeTree(id: String) =
		ChromeBookmarks.removeTree(id).await()

	/**
	 * Searches for BookmarkTreeNodes matching the given query. Queries specified with an object produce BookmarkTreeNodes matching all specified properties.
	 * @param query Either a string of words and quoted phrases that are matched against bookmark URLs and titles, or an object. If an object, the properties `query`, `url`, and `title` may be specified and bookmarks matching all specified properties will be produced.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun search(query: String): List<BookmarkTreeNode> =
		ChromeBookmarks.search(query).await().asList()

	/**
	 * Searches for BookmarkTreeNodes matching the given query. Queries specified with an object produce BookmarkTreeNodes matching all specified properties.
	 * @param query Either a string of words and quoted phrases that are matched against bookmark URLs and titles, or an object. If an object, the properties `query`, `url`, and `title` may be specified and bookmarks matching all specified properties will be produced.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun search(query: SearchQuery): List<BookmarkTreeNode> =
		ChromeBookmarks.search(query).await().asList()

	/**
	 * Updates the properties of a bookmark or folder. Specify only the properties that you want to change; unspecified properties will be left unchanged. **Note:** Currently, only 'title' and 'url' are supported.
	 *
	 * Suspend version enabled since Chrome Chrome 90
	 */
	suspend fun update(id: String, changes: UpdateChanges): BookmarkTreeNode =
		ChromeBookmarks.update(id, changes).await()
}

