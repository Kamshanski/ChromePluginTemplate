package chrome.storage

external interface StorageAreaSetAccessLevelAccessOptions {

	var accessLevel: AccessLevel
}

fun StorageAreaSetAccessLevelAccessOptions(
	/** The access level to set. */
	accessLevel: AccessLevel,
): StorageAreaSetAccessLevelAccessOptions =
	js("{}").unsafeCast<StorageAreaSetAccessLevelAccessOptions>().apply {
		this.accessLevel = accessLevel
	}