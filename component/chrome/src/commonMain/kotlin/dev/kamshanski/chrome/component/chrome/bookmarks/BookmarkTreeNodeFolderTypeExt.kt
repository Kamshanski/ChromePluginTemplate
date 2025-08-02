package dev.kamshanski.chrome.component.chrome.bookmarks

import chrome.bookmarks.BookmarkTreeNode
import chrome.bookmarks.FolderType

val BookmarkTreeNode.bookmarksBarFolder: Boolean
	get() = folderType == FolderType.BOOKMARKS_BAR.value

fun BookmarkTreeNode.findBookmarksBarNodeOrNull(): BookmarkTreeNode? {
	if (bookmarksBarFolder) {
		return this
	}

	return childList?.firstNotNullOfOrNull { it.findBookmarksBarNodeOrNull() }
}