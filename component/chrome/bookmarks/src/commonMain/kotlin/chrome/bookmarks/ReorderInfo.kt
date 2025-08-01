@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

import kotlin.js.collections.JsReadonlyArray

external interface ReorderInfo {

	var childIds: JsReadonlyArray<String>
}