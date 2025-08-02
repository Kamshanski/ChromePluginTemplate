@file:JsQualifier("chrome")

package chrome.bookmarks

import chrome.events.Event
import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

@Suppress("unused")
@JsName("bookmarks")
/**
 * Use the `chrome.bookmarks` API to create, organize, and otherwise manipulate bookmarks. Also see Override Pages, which you can use to create a custom Bookmark Manager page.
 *
 * Permissions: "bookmarks"
 */
external object ChromeBookmarks {

	/** @deprecated Bookmark write operations are no longer limited by Chrome. */
	val MAX_WRITE_OPERATIONS_PER_HOUR: Double /* 1000000 */

	/** @deprecated Bookmark write operations are no longer limited by Chrome. */
	val MAX_SUSTAINED_WRITE_OPERATIONS_PER_MINUTE: Double /* 1000000 */

	/** Fired when a bookmark or folder changes. **Note:** Currently, only title and url changes trigger this.*/
	val onChanged: Event<(id: String, changeInfo: ChangeInfo) -> Unit>

	/** Fired when the children of a folder have changed their order due to the order being sorted in the UI. This is not called as a result of a move(). */
	val onChildrenReordered: Event<(id: String, reorderInfo: ReorderInfo) -> Unit>

	/** Fired when a bookmark or folder is created. */
	val onCreated: Event<(id: String, bookmark: BookmarkTreeNode) -> Unit>

	/** Fired when a bookmark import session is begun. Expensive observers should ignore onCreated updates until onImportEnded is fired. Observers should still handle other notifications immediately. */
	val onImportBegan: Event<() -> Unit>

	/** Fired when a bookmark import session is ended.  */
	val onImportEnded: Event<() -> Unit>

	/** Fired when a bookmark or folder is moved to a different parent folder. */
	val onMoved: Event<(id: String, moveInfo: MoveInfo) -> Unit>

	/** Fired when a bookmark or folder is removed. When a folder is removed recursively, a single notification is fired for the folder, and none for its contents. */
	val onRemoved: Event<(id: String, removeInfo: RemoveInfo) -> Unit>

	/**
	 * Creates a bookmark or folder under the specified parentId. If url is NULL or missing, it will be a folder.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	fun create(bookmark: CreateDetails): Promise<BookmarkTreeNode>
	fun create(bookmark: CreateDetails, callback: (result: BookmarkTreeNode) -> Unit)

	/**
	 * Retrieves the entire Bookmarks hierarchy.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun getTree(): Promise<JsReadonlyArray<BookmarkTreeNode>>
	fun getTree(callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit)

	/**
	 * Retrieves the specified BookmarkTreeNode(s).
	 * @param id A single string-valued id, or an array of string-valued ids
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	fun get(id: String): Promise<JsReadonlyArray<BookmarkTreeNode>>

	/**
	 * Retrieves the specified BookmarkTreeNode(s).
	 * @param idList A single string-valued id, or an array of string-valued ids
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	fun get(
		idList: Array<String> /* [string, ...string[]] */
	): Promise<JsReadonlyArray<BookmarkTreeNode>>

	fun get(id: String, callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit)
	fun get(
		idList: Array<String> /* [string, ...string[]]*/,
		callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit
	)

	/**
	 * Retrieves the children of the specified BookmarkTreeNode id.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun getChildren(id: String): Promise<JsReadonlyArray<BookmarkTreeNode>>
	fun getChildren(id: String, callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit)

	/**
	 *  Retrieves the recently added bookmarks.
	 * @param numberOfItems The maximum number of items to return.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun getRecent(numberOfItems: Double): Promise<JsReadonlyArray<BookmarkTreeNode>>
	fun getRecent(numberOfItems: Double, callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit)

	/**
	 * Retrieves part of the Bookmarks hierarchy, starting at the specified node.
	 * @param id The ID of the root of the subtree to retrieve.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun getSubTree(id: String): Promise<JsReadonlyArray<BookmarkTreeNode>>
	fun getSubTree(id: String, callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit)

	/**
	 * Moves the specified BookmarkTreeNode to the provided location.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun move(id: String, destination: MoveDestination): Promise<BookmarkTreeNode>
	fun move(id: String, destination: MoveDestination, callback: (result: BookmarkTreeNode) -> Unit)

	/**
	 * Removes a bookmark or an empty bookmark folder.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun remove(id: String): Promise<Unit>
	fun remove(id: String, callback: () -> Unit)

	/**
	 * Recursively removes a bookmark folder.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun removeTree(id: String): Promise<Unit>
	fun removeTree(id: String, callback: () -> Unit)

	/**
	 * Searches for BookmarkTreeNodes matching the given query. Queries specified with an object produce BookmarkTreeNodes matching all specified properties.
	 * @param query Either a string of words and quoted phrases that are matched against bookmark URLs and titles, or an object. If an object, the properties `query`, `url`, and `title` may be specified and bookmarks matching all specified properties will be produced.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun search(query: String): Promise<JsReadonlyArray<BookmarkTreeNode>>

	/**
	 * Searches for BookmarkTreeNodes matching the given query. Queries specified with an object produce BookmarkTreeNodes matching all specified properties.
	 * @param query Either a string of words and quoted phrases that are matched against bookmark URLs and titles, or an object. If an object, the properties `query`, `url`, and `title` may be specified and bookmarks matching all specified properties will be produced.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun search(query: SearchQuery): Promise<JsReadonlyArray<BookmarkTreeNode>>
	fun search(query: String, callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit)
	fun search(query: SearchQuery, callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit)

	/**
	 * Updates the properties of a bookmark or folder. Specify only the properties that you want to change; unspecified properties will be left unchanged. **Note:** Currently, only 'title' and 'url' are supported.
	 *
	 * Can return its result via Promise since Chrome Chrome 90
	 */
	fun update(id: String, changes: UpdateChanges): Promise<BookmarkTreeNode>
	fun update(id: String, changes: UpdateChanges, callback: (result: BookmarkTreeNode) -> Unit)
}