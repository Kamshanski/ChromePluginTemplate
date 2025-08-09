@file:JsQualifier("chrome")

package chrome.storage

import chrome.events.Event

/**
 * Use the `chrome.storage` API to store, retrieve, and track changes to user data.
 *
 * Permissions: "storage"
 */
@Suppress("unused")
@JsName("storage")
external object ChromeStorage {

	/** Items in the local storage area are local to each machine. */
	var local: LocalStorageArea

	/** Items in the sync storage area are synced using Chrome Sync. */
	var sync: SyncStorageArea

	/**
	 * Items in the managed storage area are set by the domain administrator, and are read-only for the extension; trying to modify this namespace results in an error.
	 * @since Chrome 33
	 */
	var managed: StorageArea

	/**
	 * Items in the session storage area are stored in-memory and will not be persisted to disk.
	 * @since Chrome 102
	 */
	var session: SessionStorageArea

	/** Fired when one or more items change. */
	var onChanged: Event<(changes: StorageChangeMap, areaName: AreaName) -> Unit>
}