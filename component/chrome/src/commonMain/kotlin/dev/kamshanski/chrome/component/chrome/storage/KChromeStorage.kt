package dev.kamshanski.chrome.component.chrome.storage

import chrome.events.Event
import chrome.storage.AreaName
import chrome.storage.ChromeStorage
import chrome.storage.StorageChangeMap

/** @see ChromeStorage */
interface KChromeStorage {

	companion object : KChromeStorage {

		/** @see ChromeStorage.local */
		override var local: LocalCoroutinesStorageArea = LocalCoroutinesStorageArea(ChromeStorage.local)

		/** @see ChromeStorage.sync */
		override var sync: SyncCoroutinesStorageArea = SyncCoroutinesStorageArea(ChromeStorage.sync)

		/** @see ChromeStorage.managed */
		override var managed: CoroutinesStorageArea = CoroutinesStorageArea(ChromeStorage.managed)

		/** @see ChromeStorage.session */
		override var session: SessionCoroutinesStorageArea = SessionCoroutinesStorageArea(ChromeStorage.session)

		/** @see ChromeStorage.onChanged */
		override var onChanged: Event<(changes: StorageChangeMap, areaName: AreaName) -> Unit> by ChromeStorage::onChanged
	}

	/** @see ChromeStorage.local */
	var local: LocalCoroutinesStorageArea

	/** @see ChromeStorage.sync */
	var sync: SyncCoroutinesStorageArea

	/** @see ChromeStorage.managed */
	var managed: CoroutinesStorageArea

	/** @see ChromeStorage.session */
	var session: SessionCoroutinesStorageArea

	/** @see ChromeStorage.onChanged */
	var onChanged: Event<(changes: StorageChangeMap, areaName: AreaName) -> Unit>
}