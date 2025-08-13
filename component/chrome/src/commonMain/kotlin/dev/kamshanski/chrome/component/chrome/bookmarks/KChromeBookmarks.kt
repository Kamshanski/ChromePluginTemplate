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
interface KChromeBookmarks {

	companion object : KChromeBookmarks {

		override val onChanged: Event<(id: String, changeInfo: ChangeInfo) -> Unit> by ChromeBookmarks::onChanged

		override val onChildrenReordered: Event<(id: String, reorderInfo: ReorderInfo) -> Unit> by ChromeBookmarks::onChildrenReordered

		override val onCreated: Event<(id: String, bookmark: BookmarkTreeNode) -> Unit> by ChromeBookmarks::onCreated

		override val onImportBegan: Event<() -> Unit> by ChromeBookmarks::onImportBegan

		override val onImportEnded: Event<() -> Unit> by ChromeBookmarks::onImportEnded

		override val onMoved: Event<(id: String, moveInfo: MoveInfo) -> Unit> by ChromeBookmarks::onMoved

		override val onRemoved: Event<(id: String, removeInfo: RemoveInfo) -> Unit> by ChromeBookmarks::onRemoved

		override suspend fun create(bookmark: CreateDetails): BookmarkTreeNode = ChromeBookmarks.create(bookmark).await()

		override suspend fun getTree(): List<BookmarkTreeNode> = ChromeBookmarks.getTree().await().asList()

		override suspend fun get(id: String): List<BookmarkTreeNode> = ChromeBookmarks.get(id).await().asList()

		override suspend fun get(idList: Array<String>): List<BookmarkTreeNode> = ChromeBookmarks.get(idList).await().asList()

		override suspend fun getChildren(id: String): List<BookmarkTreeNode> = ChromeBookmarks.getChildren(id).await().asList()

		override suspend fun getRecent(numberOfItems: Int): List<BookmarkTreeNode> = ChromeBookmarks.getRecent(numberOfItems).await().asList()

		override suspend fun getSubTree(id: String): List<BookmarkTreeNode> = ChromeBookmarks.getSubTree(id).await().asList()

		override suspend fun move(id: String, destination: MoveDestination): BookmarkTreeNode = ChromeBookmarks.move(id, destination).await()

		override suspend fun remove(id: String) = ChromeBookmarks.remove(id).await()

		override suspend fun removeTree(id: String) = ChromeBookmarks.removeTree(id).await()

		override suspend fun search(query: String): List<BookmarkTreeNode> = ChromeBookmarks.search(query).await().asList()

		override suspend fun search(query: SearchQuery): List<BookmarkTreeNode> = ChromeBookmarks.search(query).await().asList()

		override suspend fun update(id: String, changes: UpdateChanges): BookmarkTreeNode = ChromeBookmarks.update(id, changes).await()
	}

	val onChanged: Event<(id: String, changeInfo: ChangeInfo) -> Unit>

	val onChildrenReordered: Event<(id: String, reorderInfo: ReorderInfo) -> Unit>

	val onCreated: Event<(id: String, bookmark: BookmarkTreeNode) -> Unit>

	val onImportBegan: Event<() -> Unit>

	val onImportEnded: Event<() -> Unit>

	val onMoved: Event<(id: String, moveInfo: MoveInfo) -> Unit>

	val onRemoved: Event<(id: String, removeInfo: RemoveInfo) -> Unit>

	suspend fun create(bookmark: CreateDetails): BookmarkTreeNode

	suspend fun getTree(): List<BookmarkTreeNode>

	suspend fun get(id: String): List<BookmarkTreeNode>

	suspend fun get(idList: Array<String>): List<BookmarkTreeNode>

	suspend fun getChildren(id: String): List<BookmarkTreeNode>

	suspend fun getRecent(numberOfItems: Int): List<BookmarkTreeNode>

	suspend fun getSubTree(id: String): List<BookmarkTreeNode>

	suspend fun move(id: String, destination: MoveDestination): BookmarkTreeNode

	suspend fun remove(id: String)

	suspend fun removeTree(id: String)

	suspend fun search(query: String): List<BookmarkTreeNode>

	suspend fun search(query: SearchQuery): List<BookmarkTreeNode>

	suspend fun update(id: String, changes: UpdateChanges): BookmarkTreeNode
}