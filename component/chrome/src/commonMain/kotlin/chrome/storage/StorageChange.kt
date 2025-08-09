package chrome.storage

external interface StorageChange {

	/** Optional. The new value of the item, if there is a new value. */
	var newValue: Any?

	/** Optional. The old value of the item, if there was an old value. */
	var oldValue: Any?
}