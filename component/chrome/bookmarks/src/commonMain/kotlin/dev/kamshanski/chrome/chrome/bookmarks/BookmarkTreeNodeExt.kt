package dev.kamshanski.chrome.chrome.bookmarks

import chrome.bookmarks.BookmarkTreeNode

val BookmarkTreeNode.isFile: Boolean
	get() = url != null

val BookmarkTreeNode.isFolder: Boolean
	get() = url == null