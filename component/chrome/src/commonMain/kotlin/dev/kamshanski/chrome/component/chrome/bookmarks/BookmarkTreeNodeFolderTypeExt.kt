package dev.kamshanski.chrome.component.chrome.bookmarks

import chrome.bookmarks.BookmarkTreeNode
import chrome.bookmarks.FolderTypeEnum

val BookmarkTreeNode.bookmarksBarFolder: Boolean
	get() = folderType == FolderTypeEnum.BOOKMARKS_BAR.value

fun BookmarkTreeNode.findBookmarksBarNodeOrNull(): BookmarkTreeNode? {
	if (bookmarksBarFolder) {
		return this
	}

	return childList?.firstNotNullOfOrNull { it.findBookmarksBarNodeOrNull() }
}