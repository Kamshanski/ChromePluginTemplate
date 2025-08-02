@file:JsQualifier("chrome")

package chrome.declarativecontent

/**
 * Use the `chrome.declarativeContent` API to take actions depending on the content of a page, without requiring permission to read the page's content.
 *
 * Permissions: "declarativeContent"
 */
@JsName("declarativeContent")
external object ChromeDeclarativeContent {

	var onPageChanged: PageChangedEvent
}