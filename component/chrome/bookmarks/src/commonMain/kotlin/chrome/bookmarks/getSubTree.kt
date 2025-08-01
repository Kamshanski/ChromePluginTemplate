@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

/**
 * Retrieves part of the Bookmarks hierarchy, starting at the specified node.
 * @param id The ID of the root of the subtree to retrieve.
 *
 * Can return its result via Promise since Chrome Chrome 90
 */
external fun getSubTree(id: String): Promise<JsReadonlyArray<BookmarkTreeNode>>
external fun getSubTree(id: String, callback: (results: JsReadonlyArray<BookmarkTreeNode>) -> Unit)