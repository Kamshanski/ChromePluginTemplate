@file:JsQualifier("chrome.declarativeContent")

package chrome.declarativecontent

import chrome.events.UrlFilter
import kotlin.js.collections.JsReadonlyArray

external class PageStateMatcherProperties {

	/** Optional. Filters URLs for various criteria. See event filtering. All criteria are case sensitive.  */
	var pageUrl: UrlFilter?

	/** Optional. Matches if all of the CSS selectors in the array match displayed elements in a frame with the same origin as the page's main frame. All selectors in this array must be compound selectors to speed up matching. Note that listing hundreds of CSS selectors or CSS selectors that match hundreds of times per page can still slow down web sites.  */
	var css: JsReadonlyArray<String>?

	/**
	 * Optional.
	 * @since Chrome 45
	 * Matches if the bookmarked state of the page is equal to the specified value. Requires the bookmarks permission.
	 */
	var isBookmarked: Boolean?
}