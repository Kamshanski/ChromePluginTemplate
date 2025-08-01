package dev.kamshanski.chrome.chrome.bookmarks

import chrome.bookmarks.BookmarkTreeNode
import dev.kamshanski.chrome.util.common.asList

val BookmarkTreeNode.isFile: Boolean
	get() = url != null

val BookmarkTreeNode.isFolder: Boolean
	get() = url == null

val BookmarkTreeNode.childList: List<BookmarkTreeNode>?
	get() = children?.asList()