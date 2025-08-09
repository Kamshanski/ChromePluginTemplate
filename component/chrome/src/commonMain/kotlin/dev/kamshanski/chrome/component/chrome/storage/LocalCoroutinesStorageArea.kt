package dev.kamshanski.chrome.component.chrome.storage

import chrome.storage.LocalStorageArea
import chrome.storage.LocalStorageMixin

class LocalCoroutinesStorageArea(delegate: LocalStorageArea):
	CoroutinesStorageArea(delegate),
	LocalStorageMixin by delegate