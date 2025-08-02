package chrome.bookmarks

fun SearchQuery(
	/** A string of words and quoted phrases that are matched against bookmark URLs and titles.*/
	query: String? = null,
	/** The URL of the bookmark; matches verbatim. Note that folders have no URL. */
	url: String? = null,
	/** The title of the bookmark; matches verbatim. */
	title: String? = null,
): SearchQuery =
	js("{}").unsafeCast<SearchQuery>().apply {
		this.query = query
		this.url = url
		this.title = title
	}