package dev.kamshanski.chrome.domain

import chrome.bookmarks.BookmarkTreeNode
import chrome.bookmarks.UpdateChanges
import dev.kamshanski.chrome.component.chrome.bookmarks.ChromeCoroutinesBookmarks
import dev.kamshanski.chrome.util.common.asList

suspend fun replaceVostorgUrlEverywhereUseCase(
	vostorgReplacement: String,
	vostorgPattern: String,
	getTree: suspend () -> List<BookmarkTreeNode> = ChromeCoroutinesBookmarks::getTree,
	update: suspend (id: String, changes: UpdateChanges) -> BookmarkTreeNode = ChromeCoroutinesBookmarks::update,
): List<UpdatedBookmark> {

	val pattern = Regex(vostorgPattern)

	val updatedBookmarks = getTree()
		.flatMapNotNullAllTree(
			transform = { node ->
				val url = node.url
				if (!url.isNullOrBlank()) NodeAndUrl(node, url)
				else null
			},
			getChildren = { it.children?.asList().orEmpty() }
		)
		.mapNotNull { (node, url) ->
			val newUrl = pattern.replace(url, vostorgReplacement)
			if (newUrl != url) {
				NodeAndNewUrl(node = node, oldUrl = url, newUrl = newUrl)
			} else {
				null
			}
		}
		.map { (node, oldUrl, newUrl) ->
			val updatedBookmark = UpdatedBookmark(id = node.id, oldUrl = oldUrl, newUrl = newUrl)
			update(node.id, UpdateChanges(url = newUrl))
			updatedBookmark
		}

	return updatedBookmarks
}

private data class NodeAndUrl(val node: BookmarkTreeNode, val url: String)
private data class NodeAndNewUrl(val node: BookmarkTreeNode, val oldUrl: String, val newUrl: String)

private fun <T, R : Any> List<T>.flatMapNotNullAllTree(transform: (T) -> R?, getChildren: (T) -> List<T>): List<R> {
	val collection = mutableListOf<R>()
	for (item in this) {
		val result = transform(item)
		result?.let { collection.add(it) }

		val children = getChildren(item)
		val childrenResult = children.flatMapNotNullAllTree(transform, getChildren)
		collection.addAll(childrenResult)
	}

	return collection
}