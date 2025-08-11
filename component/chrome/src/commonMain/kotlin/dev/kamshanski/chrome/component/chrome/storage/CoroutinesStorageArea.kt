package dev.kamshanski.chrome.component.chrome.storage

import chrome.events.Event
import chrome.storage.StorageArea
import chrome.storage.StorageAreaSetAccessLevelAccessOptions
import chrome.storage.StorageChangeMap
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await
import kotlin.js.Json

@OptIn(ExperimentalJsExport::class)
open class CoroutinesStorageArea(val delegate: StorageArea) {

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param keys Optional. A single key or list of keys to get the total usage for. An empty list will return 0. Pass in null to get the total usage of all of storage.
	 * @return A Promise that resolves with a number
	 * @since MV3
	 */
	suspend fun getBytesInUse(keys: Nothing?): Int = delegate.getBytesInUse(null).await()

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param keys Optional. A single key or list of keys to get the total usage for. An empty list will return 0. Pass in null to get the total usage of all of storage.
	 * @return A Promise that resolves with a number
	 * @since MV3
	 */
	suspend fun getBytesInUse(keys: String): Int = delegate.getBytesInUse(keys).await()

	/**
	 * Gets the amount of space (in bytes) being used by one or more items.
	 * @param keys Optional. A single key or list of keys to get the total usage for. An empty list will return 0. Pass in null to get the total usage of all of storage.
	 * @return A Promise that resolves with a number
	 * @since MV3
	 */
	suspend fun getBytesInUse(keys: List<String>): Int = delegate.getBytesInUse(keys.toTypedArray()).await()

	/**
	 * Removes all items from storage.
	 * @return A void Promise
	 * @since MV3
	 */
	suspend fun clear(): Unit = delegate.clear().await()

	/**
	 * Sets multiple items.
	 * @param items An object which gives each key/value pair to update storage with. Any other key/value pairs in storage will not be affected.
	 * Primitive values such as numbers will serialize as expected. Values with a typeof "object" and "function" will typically serialize to {}, with the exception of Array (serializes as expected), Date, and Regex (serialize using their String representation).
	 * @return A void Promise
	 * @since MV3
	 */
	suspend fun set(items: Json): Unit = delegate.set(items).await()

	/**
	 * Removes one or more items from storage.
	 * @param keys A single key or a list of keys for items to remove.
	 * @param callback Optional.
	 * @return A void Promise
	 * @since MV3
	 */
	suspend fun remove(keys: String): Unit = delegate.remove(keys).await()

	/**
	 * Removes one or more items from storage.
	 * @param keys A single key or a list of keys for items to remove.
	 * @param callback Optional.
	 * @return A void Promise
	 * @since MV3
	 */
	suspend fun remove(keys: List<String>): Unit = delegate.remove(keys.toTypedArray()).await()

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @return A Promise that resolves with an object containing items
	 * @since MV3
	 */
	suspend fun get(keys: String?): Json = delegate.get(keys).await()

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @return A Promise that resolves with an object containing items
	 * @since MV3
	 */
	suspend fun get(keys: List<String>): Json = delegate.get(keys.toTypedArray()).await()

	/**
	 * Gets one or more items from storage.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @return A Promise that resolves with an object containing items
	 * @since MV3
	 */
	suspend fun get(keys: Json): Json = delegate.get(keys).await() as Json

	/**
	 * Sets the desired access level for the storage area. The default will be only trusted contexts.
	 * @param accessOptions An object containing an accessLevel key which contains the access level of the storage area.
	 * @return A void Promise.
	 * @since Chrome 102
	 */
	suspend fun setAccessLevel(accessOptions: StorageAreaSetAccessLevelAccessOptions): Unit = delegate.setAccessLevel(accessOptions).await()

	/**
	 * Gets all keys from storage.
	 * @return A Promise that resolves with an array of keys.
	 * @since Chrome 130
	 */
	suspend fun getKeys(): List<String> = delegate.getKeys().await().asList()

	/**
	 * Fired when one or more items change within this storage area.
	 * @param keys A single key to get, list of keys to get, or a dictionary specifying default values.
	 * An empty list or object will return an empty result object. Pass in null to get the entire contents of storage.
	 * @param callback Callback with storage items, or on failure (in which case runtime.lastError will be set).
	 * Parameter items: Object with items in their key-value mappings.
	 */
	var onChanged: Event<(changes: StorageChangeMap) -> Unit> by delegate::onChanged
}

