package dev.kamshanski.chrome.component.chrome.storage

import chrome.storage.SessionStorageArea
import chrome.storage.SessionStorageMixin

class SessionCoroutinesStorageArea(delegate: SessionStorageArea):
	CoroutinesStorageArea(delegate),
	SessionStorageMixin by delegate