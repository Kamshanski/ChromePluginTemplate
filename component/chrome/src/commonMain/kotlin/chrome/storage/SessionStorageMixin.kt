package chrome.storage

external interface SessionStorageMixin {

	/** The maximum amount (in bytes) of data that can be stored in memory, as measured by estimating the dynamically allocated memory usage of every value and key. Updates that would cause this limit to be exceeded fail immediately and set runtime.lastError. */
	var QUOTA_BYTES: Int
}