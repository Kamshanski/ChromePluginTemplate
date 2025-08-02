@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

/** Object passed to the create() function. */
external interface CreateDetails {

	var index: Int?

	/** Defaults to the Other Bookmarks folder. */
	var parentId: String?
	var title: String?
	var url: String?
}