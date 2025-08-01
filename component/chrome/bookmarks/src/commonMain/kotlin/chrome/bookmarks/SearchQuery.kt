@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

external interface SearchQuery {

	/** A string of words and quoted phrases that are matched against bookmark URLs and titles.*/
	var query: String?

	/** The URL of the bookmark; matches verbatim. Note that folders have no URL. */
	var url: String?

	/** The title of the bookmark; matches verbatim. */
	var title: String?
}