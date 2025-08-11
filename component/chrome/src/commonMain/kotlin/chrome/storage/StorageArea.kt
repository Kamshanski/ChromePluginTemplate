package chrome.storage

import chrome.events.Event
import kotlin.js.Json
import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

@Suppress("unused")
external interface StorageArea {

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param keys Optional. A single key or list of keys to get the total usage for. An empty list will return 0. Pass in null to get the total usage of all of storage.
	 * @return A Promise that resolves with a number
	 * @since MV3
	 */
	fun getBytesInUse(keys: Nothing?): Promise<Int>

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param keys Optional. A single key or list of keys to get the total usage for. An empty list will return 0. Pass in null to get the total usage of all of storage.
	 * @return A Promise that resolves with a number
	 * @since MV3
	 */
	fun getBytesInUse(keys: String? = definedExternally): Promise<Int>

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param keys Optional. A single key or list of keys to get the total usage for. An empty list will return 0. Pass in null to get the total usage of all of storage.
	 * @return A Promise that resolves with a number
	 * @since MV3
	 */
	fun getBytesInUse(keys: Array<String>? = definedExternally): Promise<Int>

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param keys Optional. A single key or list of keys to get the total usage for. An empty list will return 0. Pass in null to get the total usage of all of storage.
	 * @param callback Callback with the amount of space being used by storage, or on failure (in which case runtime.lastError will be set).
	 * Parameter bytesInUse: Amount of space being used in storage, in bytes.
	 */
	fun getBytesInUse(keys: String?, callback: (bytesInUse: Int) -> Unit)

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param keys Optional. A single key or list of keys to get the total usage for. An empty list will return 0. Pass in null to get the total usage of all of storage.
	 * @param callback Callback with the amount of space being used by storage, or on failure (in which case runtime.lastError will be set).
	 * Parameter bytesInUse: Amount of space being used in storage, in bytes.
	 */
	fun getBytesInUse(keys: Array<String>?, callback: (bytesInUse: Int) -> Unit)

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param callback Callback with the amount of space being used by storage, or on failure (in which case runtime.lastError will be set).
	 * Parameter bytesInUse: Amount of space being used in storage, in bytes.
	 */
	fun getBytesInUse(callback: (bytesInUse: Int) -> Unit)

	/**
	 * Removes all items from storage.
	 * @return A void Promise
	 * @since MV3
	 */
	fun clear(): Promise<Unit>

	/**
	 * Removes all items from storage.
	 * @param callback Optional.
	 * Callback on success, or on failure (in which case runtime.lastError will be set).
	 */
	fun clear(callback: () -> Unit)

	/**
	 * Sets multiple items.
	 * @param items An object which gives each key/value pair to update storage with. Any other key/value pairs in storage will not be affected.
	 * Primitive values such as numbers will serialize as expected. Values with a typeof "object" and "function" will typically serialize to {}, with the exception of Array (serializes as expected), Date, and Regex (serialize using their String representation).
	 * @return A void Promise
	 * @since MV3
	 */
	fun set(items: Json): Promise<Unit>

	/**
	 * Sets multiple items.
	 * @param items An object which gives each key/value pair to update storage with. Any other key/value pairs in storage will not be affected.
	 * Primitive values such as numbers will serialize as expected. Values with a typeof "object" and "function" will typically serialize to {}, with the exception of Array (serializes as expected), Date, and Regex (serialize using their String representation).
	 * @param callback Optional.
	 * Callback on success, or on failure (in which case runtime.lastError will be set).
	 */
	fun set(items: Json, callback: () -> Unit)

	/**
	 * Removes one or more items from storage.
	 * @param keys A single key or a list of keys for items to remove.
	 * @param callback Optional.
	 * @return A void Promise
	 * @since MV3
	 */
	fun remove(keys: String): Promise<Unit>

	/**
	 * Removes one or more items from storage.
	 * @param keys A single key or a list of keys for items to remove.
	 * @param callback Optional.
	 * @return A void Promise
	 * @since MV3
	 */
	fun remove(keys: Array<String>): Promise<Unit>

	/**
	 * Removes one or more items from storage.
	 * @param keys A single key or a list of keys for items to remove.
	 * @param callback Optional.
	 * Callback on success, or on failure (in which case runtime.lastError will be set).
	 */
	fun remove(keys: String, callback: () -> Unit)

	/**
	 * Removes one or more items from storage.
	 * @param keys A single key or a list of keys for items to remove.
	 * @param callback Optional.
	 * Callback on success, or on failure (in which case runtime.lastError will be set).
	 */
	fun remove(keys: Array<String>, callback: () -> Unit)

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @return A Promise that resolves with an object containing items
	 * @since MV3
	 */
	fun <T> get(keys: Nothing?): Promise<T>

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @return A Promise that resolves with an object containing items
	 * @since MV3
	 */
	fun get(keys: String? = definedExternally): Promise<Json>

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @return A Promise that resolves with an object containing items
	 * @since MV3
	 */
	fun get(keys: Array<String>? = definedExternally): Promise<Json>

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @return A Promise that resolves with an object containing items
	 * @since MV3
	 */
	fun get(keys: Json? = definedExternally): Promise<Json>

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @param callback Callback with storage items, or on failure (in which case runtime.lastError will be set).
	 * Parameter items: Object with items in their key-value mappings.
	 */
	fun get(keys: String?, callback: (items: Json) -> Unit)

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @param callback Callback with storage items, or on failure (in which case runtime.lastError will be set).
	 * Parameter items: Object with items in their key-value mappings.
	 */
	fun get(keys: Array<String>?, callback: (items: Json) -> Unit)

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @param callback Callback with storage items, or on failure (in which case runtime.lastError will be set).
	 * Parameter items: Object with items in their key-value mappings.
	 */
	fun get(keys: Json?, callback: (items: Json) -> Unit)

	/**
	 * Gets the entire contents of storage.
	 * @param callback Callback with storage items, or on failure (in which case runtime.lastError will be set).
	 * Parameter items: Object with items in their key-value mappings.
	 */
	fun get(callback: (items: Json) -> Unit)

	/**
	 * Sets the desired access level for the storage area. The default will be only trusted contexts.
	 * @param accessOptions An object containing an accessLevel key which contains the access level of the storage area.
	 * @return A void Promise.
	 * @since Chrome 102
	 */
	fun setAccessLevel(accessOptions: StorageAreaSetAccessLevelAccessOptions): Promise<Unit>

	/**
	 * Sets the desired access level for the storage area. The default will be only trusted contexts.
	 * @param accessOptions An object containing an accessLevel key which contains the access level of the storage area.
	 * @param callback Optional.
	 * @since Chrome 102
	 */
	fun setAccessLevel(accessOptions: StorageAreaSetAccessLevelAccessOptions, callback: () -> Unit)

	/**
	 * Gets all keys from storage.
	 * @return A Promise that resolves with an array of keys.
	 * @since Chrome 130
	 */
	fun getKeys(): Promise<JsReadonlyArray<String>>

	/**
	 * Gets all keys from storage.
	 * @param callback Callback with storage keys.
	 * Parameter keys: Array of keys in storage.
	 * @since Chrome 130
	 */
	fun getKeys(callback: (keys: JsReadonlyArray<String>) -> Unit)

	/**
	 * Fired when one or more items change within this storage area.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @param callback Callback with storage items, or on failure (in which case runtime.lastError will be set).
	 * Parameter items: Object with items in their key-value mappings.
	 */
	var onChanged: Event<(changes: StorageChangeMap) -> Unit>
}

