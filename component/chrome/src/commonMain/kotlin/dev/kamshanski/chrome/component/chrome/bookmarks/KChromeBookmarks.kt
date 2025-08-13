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

/** @see ChromeBookmarks */
interface KChromeBookmarks {

	companion object : KChromeBookmarks {

		/** @see ChromeBookmarks.onChanged */
		override val onChanged: Event<(id: String, changeInfo: ChangeInfo) -> Unit> by ChromeBookmarks::onChanged

		/** @see ChromeBookmarks.onChildrenReordered */
		override val onChildrenReordered: Event<(id: String, reorderInfo: ReorderInfo) -> Unit> by ChromeBookmarks::onChildrenReordered

		/** @see ChromeBookmarks.onCreated */
		override val onCreated: Event<(id: String, bookmark: BookmarkTreeNode) -> Unit> by ChromeBookmarks::onCreated

		/** @see ChromeBookmarks.onImportBegan */
		override val onImportBegan: Event<() -> Unit> by ChromeBookmarks::onImportBegan

		/** @see ChromeBookmarks.onImportEnded */
		override val onImportEnded: Event<() -> Unit> by ChromeBookmarks::onImportEnded

		/** @see ChromeBookmarks.onMoved */
		override val onMoved: Event<(id: String, moveInfo: MoveInfo) -> Unit> by ChromeBookmarks::onMoved

		/** @see ChromeBookmarks.onRemoved */
		override val onRemoved: Event<(id: String, removeInfo: RemoveInfo) -> Unit> by ChromeBookmarks::onRemoved

		/** @see ChromeBookmarks.create */
		override suspend fun create(bookmark: CreateDetails): BookmarkTreeNode = ChromeBookmarks.create(bookmark).await()

		/** @see ChromeBookmarks.getTree */
		override suspend fun getTree(): List<BookmarkTreeNode> = ChromeBookmarks.getTree().await().asList()

		/** @see ChromeBookmarks.get */
		override suspend fun get(id: String): List<BookmarkTreeNode> = ChromeBookmarks.get(id).await().asList()

		/** @see ChromeBookmarks.get */
		override suspend fun get(idList: Array<String>): List<BookmarkTreeNode> = ChromeBookmarks.get(idList).await().asList()

		/** @see ChromeBookmarks.getChildren */
		override suspend fun getChildren(id: String): List<BookmarkTreeNode> = ChromeBookmarks.getChildren(id).await().asList()

		/** @see ChromeBookmarks.getRecent */
		override suspend fun getRecent(numberOfItems: Int): List<BookmarkTreeNode> = ChromeBookmarks.getRecent(numberOfItems).await().asList()

		/** @see ChromeBookmarks.getSubTree */
		override suspend fun getSubTree(id: String): List<BookmarkTreeNode> = ChromeBookmarks.getSubTree(id).await().asList()

		/** @see ChromeBookmarks.move */
		override suspend fun move(id: String, destination: MoveDestination): BookmarkTreeNode = ChromeBookmarks.move(id, destination).await()

		/** @see ChromeBookmarks.remove */
		override suspend fun remove(id: String) = ChromeBookmarks.remove(id).await()

		/** @see ChromeBookmarks.removeTree */
		override suspend fun removeTree(id: String) = ChromeBookmarks.removeTree(id).await()

		/** @see ChromeBookmarks.search */
		override suspend fun search(query: String): List<BookmarkTreeNode> = ChromeBookmarks.search(query).await().asList()

		/** @see ChromeBookmarks.search */
		override suspend fun search(query: SearchQuery): List<BookmarkTreeNode> = ChromeBookmarks.search(query).await().asList()

		/** @see ChromeBookmarks.update */
		override suspend fun update(id: String, changes: UpdateChanges): BookmarkTreeNode = ChromeBookmarks.update(id, changes).await()
	}

	/** @see ChromeBookmarks.onChanged */
	val onChanged: Event<(id: String, changeInfo: ChangeInfo) -> Unit>

	/** @see ChromeBookmarks.onChildrenReordered */
	val onChildrenReordered: Event<(id: String, reorderInfo: ReorderInfo) -> Unit>

	/** @see ChromeBookmarks.onCreated */
	val onCreated: Event<(id: String, bookmark: BookmarkTreeNode) -> Unit>

	/** @see ChromeBookmarks.onImportBegan */
	val onImportBegan: Event<() -> Unit>

	/** @see ChromeBookmarks.onImportEnded */
	val onImportEnded: Event<() -> Unit>

	/** @see ChromeBookmarks.onMoved */
	val onMoved: Event<(id: String, moveInfo: MoveInfo) -> Unit>

	/** @see ChromeBookmarks.onRemoved */
	val onRemoved: Event<(id: String, removeInfo: RemoveInfo) -> Unit>

	/** @see ChromeBookmarks.create */
	suspend fun create(bookmark: CreateDetails): BookmarkTreeNode

	/** @see ChromeBookmarks.getTree */
	suspend fun getTree(): List<BookmarkTreeNode>

	/** @see ChromeBookmarks.get */
	suspend fun get(id: String): List<BookmarkTreeNode>

	/** @see ChromeBookmarks.get */
	suspend fun get(idList: Array<String>): List<BookmarkTreeNode>

	/** @see ChromeBookmarks.getChildren */
	suspend fun getChildren(id: String): List<BookmarkTreeNode>

	/** @see ChromeBookmarks.getRecent */
	suspend fun getRecent(numberOfItems: Int): List<BookmarkTreeNode>

	/** @see ChromeBookmarks.getSubTree */
	suspend fun getSubTree(id: String): List<BookmarkTreeNode>

	/** @see ChromeBookmarks.move */
	suspend fun move(id: String, destination: MoveDestination): BookmarkTreeNode

	/** @see ChromeBookmarks.remove */
	suspend fun remove(id: String)

	/** @see ChromeBookmarks.removeTree */
	suspend fun removeTree(id: String)

	/** @see ChromeBookmarks.search */
	suspend fun search(query: String): List<BookmarkTreeNode>

	/** @see ChromeBookmarks.search */
	suspend fun search(query: SearchQuery): List<BookmarkTreeNode>

	/** @see ChromeBookmarks.update */
	suspend fun update(id: String, changes: UpdateChanges): BookmarkTreeNode
}