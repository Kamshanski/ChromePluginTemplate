package chrome.storage

external interface StorageChangeMap {

	operator fun get(key: String): StorageChange?
}