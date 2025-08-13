package dev.kamshanski.chrome.component.chrome.storage

import chrome.storage.SyncStorageArea
import chrome.storage.SyncStorageMixin

class SyncCoroutinesStorageArea(delegate: SyncStorageArea):
	CoroutinesStorageArea(delegate),
	SyncStorageMixin by delegate