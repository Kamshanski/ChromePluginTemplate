package dev.kamshanski.chrome.component.chrome.storage

import chrome.events.Event
import chrome.storage.AreaName
import chrome.storage.ChromeStorage
import chrome.storage.StorageChangeMap

@Suppress("unused")
interface KChromeStorage {

	companion object : KChromeStorage {

		override var local: LocalCoroutinesStorageArea = LocalCoroutinesStorageArea(ChromeStorage.local)

		override var sync: SyncCoroutinesStorageArea = SyncCoroutinesStorageArea(ChromeStorage.sync)

		override var managed: CoroutinesStorageArea = CoroutinesStorageArea(ChromeStorage.managed)

		override var session: SessionCoroutinesStorageArea = SessionCoroutinesStorageArea(ChromeStorage.session)

		override var onChanged: Event<(changes: StorageChangeMap, areaName: AreaName) -> Unit> by ChromeStorage::onChanged
	}

	var local: LocalCoroutinesStorageArea

	var sync: SyncCoroutinesStorageArea

	var managed: CoroutinesStorageArea

	var session: SessionCoroutinesStorageArea

	var onChanged: Event<(changes: StorageChangeMap, areaName: AreaName) -> Unit>
}