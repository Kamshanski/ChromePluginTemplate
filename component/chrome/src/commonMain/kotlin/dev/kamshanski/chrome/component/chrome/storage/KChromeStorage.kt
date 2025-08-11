package dev.kamshanski.chrome.component.chrome.storage

import chrome.events.Event
import chrome.storage.AreaName
import chrome.storage.ChromeStorage
import chrome.storage.StorageChangeMap

/**
 * Use the `chrome.storage` API to store, retrieve, and track changes to user data.
 *
 * Permissions: "storage"
 */
@Suppress("unused")
object KChromeStorage {

	/** Items in the local storage area are local to each machine. */
	var local: LocalCoroutinesStorageArea = LocalCoroutinesStorageArea(ChromeStorage.local)

	/** Items in the sync storage area are synced using Chrome Sync. */
	var sync: SyncCoroutinesStorageArea = SyncCoroutinesStorageArea(ChromeStorage.sync)

	/**
	 * Items in the managed storage area are set by the domain administrator, and are read-only for the extension; trying to modify this namespace results in an error.
	 * @since Chrome 33
	 */
	var managed: CoroutinesStorageArea = CoroutinesStorageArea(ChromeStorage.managed)

	/**
	 * Items in the session storage area are stored in-memory and will not be persisted to disk.
	 * @since Chrome 102
	 */
	var session: SessionCoroutinesStorageArea = SessionCoroutinesStorageArea(ChromeStorage.session)

	/** Fired when one or more items change. */
	var onChanged: Event<(changes: StorageChangeMap, areaName: AreaName) -> Unit> by ChromeStorage::onChanged
}