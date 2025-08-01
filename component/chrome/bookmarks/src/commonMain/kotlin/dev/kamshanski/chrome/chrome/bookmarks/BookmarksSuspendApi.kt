package dev.kamshanski.chrome.chrome.bookmarks

import chrome.BookmarksApi
import chrome.bookmarks.BookmarkTreeNode
import chrome.bookmarks.ChangeInfo
import chrome.bookmarks.CreateDetails
import chrome.bookmarks.MoveDestination
import chrome.bookmarks.MoveInfo
import chrome.bookmarks.RemoveInfo
import chrome.bookmarks.ReorderInfo
import chrome.bookmarks.SearchQuery
import chrome.bookmarks.UpdateChanges
import chrome.events.Event
import kotlinx.coroutines.await
import kotlin.js.collections.JsReadonlyArray
import dev.kamshanski.chrome.util.common.asList

@Suppress("unused")
object BookmarksSuspendApi {

	/** Fired when a bookmark or folder changes. **Note:** Currently, only title and url changes trigger this.*/
	val onChanged: Event<(id: String, changeInfo: ChangeInfo) -> Unit> = BookmarksApi.onChanged

	/** Fired when the children of a folder have changed their order due to the order being sorted in the UI. This is not called as a result of a move(). */
	val onChildrenReordered: Event<(id: String, reorderInfo: ReorderInfo) -> Unit> = BookmarksApi.onChildrenReordered

	/** Fired when a bookmark or folder is created. */
	val onCreated: Event<(id: String, bookmark: BookmarkTreeNode) -> Unit> = BookmarksApi.onCreated

	/** Fired when a bookmark import session is begun. Expensive observers should ignore onCreated updates until onImportEnded is fired. Observers should still handle other notifications immediately. */
	val onImportBegan: Event<() -> Unit> = BookmarksApi.onImportBegan

	/** Fired when a bookmark import session is ended.  */
	val onImportEnded: Event<() -> Unit> = BookmarksApi.onImportEnded

	/** Fired when a bookmark or folder is moved to a different parent folder. */
	val onMoved: Event<(id: String, moveInfo: MoveInfo) -> Unit> = BookmarksApi.onMoved

	/** Fired when a bookmark or folder is removed. When a folder is removed recursively, a single notification is fired for the folder, and none for its contents. */
	val onRemoved: Event<(id: String, removeInfo: RemoveInfo) -> Unit> = BookmarksApi.onRemoved

	/**
	 * Creates a bookmark or folder under the specified parentId. If url is NULL or missing, it will be a folder.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	suspend fun create(bookmark: CreateDetails): BookmarkTreeNode =
		BookmarksApi.create(bookmark).await()

	/**
	 * Retrieves the entire Bookmarks hierarchy.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun getTree(): List<BookmarkTreeNode> {
		return BookmarksApi.getTree().await().asList()
	}

	/**
	 * Retrieves the specified BookmarkTreeNode(s).
	 * @param id A single string-valued id, or an array of string-valued ids
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	suspend fun get(id: String): JsReadonlyArray<BookmarkTreeNode> =
		BookmarksApi.get(id).await()

	/**
	 * Retrieves the specified BookmarkTreeNode(s).
	 * @param idList A single string-valued id, or an array of string-valued ids
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	suspend fun get(
		idList: Array<String>
	): JsReadonlyArray<BookmarkTreeNode> =
		BookmarksApi.get(idList).await()

	/**
	 * Retrieves the children of the specified BookmarkTreeNode id.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun getChildren(id: String): JsReadonlyArray<BookmarkTreeNode> =
		BookmarksApi.getChildren(id).await()

	/**
	 * Retrieves the recently added bookmarks.
	 * @param numberOfItems The maximum number of items to return.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun getRecent(numberOfItems: Double): JsReadonlyArray<BookmarkTreeNode> =
		BookmarksApi.getRecent(numberOfItems).await()

	/**
	 * Retrieves part of the Bookmarks hierarchy, starting at the specified node.
	 * @param id The ID of the root of the subtree to retrieve.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun getSubTree(id: String): JsReadonlyArray<BookmarkTreeNode> =
		BookmarksApi.getSubTree(id).await()

	/**
	 * Moves the specified BookmarkTreeNode to the provided location.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun move(id: String, destination: MoveDestination): BookmarkTreeNode =
		BookmarksApi.move(id, destination).await()

	/**
	 * Removes a bookmark or an empty bookmark folder.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun remove(id: String) =
		BookmarksApi.remove(id).await()

	/**
	 * Recursively removes a bookmark folder.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun removeTree(id: String) =
		BookmarksApi.removeTree(id).await()

	/**
	 * Searches for BookmarkTreeNodes matching the given query. Queries specified with an object produce BookmarkTreeNodes matching all specified properties.
	 * @param query Either a string of words and quoted phrases that are matched against bookmark URLs and titles, or an object. If an object, the properties `query`, `url`, and `title` may be specified and bookmarks matching all specified properties will be produced.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun search(query: String): JsReadonlyArray<BookmarkTreeNode> =
		BookmarksApi.search(query).await()

	/**
	 * Searches for BookmarkTreeNodes matching the given query. Queries specified with an object produce BookmarkTreeNodes matching all specified properties.
	 * @param query Either a string of words and quoted phrases that are matched against bookmark URLs and titles, or an object. If an object, the properties `query`, `url`, and `title` may be specified and bookmarks matching all specified properties will be produced.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun search(query: SearchQuery): JsReadonlyArray<BookmarkTreeNode> =
		BookmarksApi.search(query).await()

	/**
	 * Updates the properties of a bookmark or folder. Specify only the properties that you want to change; unspecified properties will be left unchanged. **Note:** Currently, only 'title' and 'url' are supported.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	suspend fun update(id: String, changes: UpdateChanges): BookmarkTreeNode =
		BookmarksApi.update(id, changes).await()
}

