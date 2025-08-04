@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks.constant

import chrome.bookmarks.FolderType

@JsName("FolderType")
internal external object FolderTypeJsEnum {

	val BOOKMARKS_BAR: FolderType
	val OTHER: FolderType
	val MOBILE: FolderType
	val MANAGED: FolderType
}