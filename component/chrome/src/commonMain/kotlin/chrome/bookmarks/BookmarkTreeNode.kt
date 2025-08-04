@file:JsQualifier("chrome.bookmarks")

package chrome.bookmarks

import kotlin.js.collections.JsReadonlyArray

/** A node (either a bookmark or a folder) in the bookmark tree. Child nodes are ordered within their parent folder. */
external interface BookmarkTreeNode {

	/** An ordered list of children of this node. */
	var children: JsReadonlyArray<BookmarkTreeNode>?

	/** When this node was created, in milliseconds since the epoch (`new Date(dateAdded)`). */
	var dateAdded: Double?

	/** When the contents of this folder last changed, in milliseconds since the epoch. */
	var dateGroupModified: Double?

	/**
	 * When this node was last opened, in milliseconds since the epoch. Not set for folders.
	 * @since Chrome 114
	 */
	var dateLastUsed: Double?

	/**
	 * If present, this is a folder that is added by the browser and that cannot be modified by the user or the extension. Child nodes may be modified, if this node does not have the `unmodifiable` property set. Omitted if the node can be modified by the user and the extension (default).
	 *
	 * There may be zero, one or multiple nodes of each folder type. A folder may be added or removed by the browser, but not via the extensions API.
	 * @since Chrome 134
	 * @see FolderType
	 */
	var folderType: FolderType?

	/** The unique identifier for the node. IDs are unique within the current profile, and they remain valid even after the browser is restarted. */
	var id: String

	/** The 0-based position of this node within its parent folder. */
	var index: Int?

	/** The `id` of the parent folder. Omitted for the root node. */
	var parentId: String?

	/**
	 * Whether this node is synced with the user's remote account storage by the browser. This can be used to distinguish between account and local-only versions of the same {@link FolderType}. The value of this property may change for an existing node, for example as a result of user action.
	 *
	 * Note: this reflects whether the node is saved to the browser's built-in account provider. It is possible that a node could be synced via a third-party, even if this value is false.
	 *
	 * For managed nodes (nodes where `unmodifiable` is set to `true`), this property will always be `false`.
	 * @since Chrome 134
	 */
	var syncing: Boolean

	/** The text displayed for the node. */
	var title: String

	/** Indicates the reason why this node is unmodifiable. The `managed` value indicates that this node was configured by the system administrator or by the custodian of a supervised user. Omitted if the node can be modified by the user and the extension (default). */
	var unmodifiable: BookmarkTreeNodeUnmodifiable?

	/** The URL navigated to when a user clicks the bookmark. Omitted for folders. */
	var url: String?
}