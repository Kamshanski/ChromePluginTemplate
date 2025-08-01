package dev.kamshanski.chromeplugintemplate.component.browserdocument

import org.w3c.dom.ItemArrayLike
import org.w3c.dom.asList

fun <T> ItemArrayLike<T>.first(): T =
	firstOrNull() ?: error("No first element in collection")

fun <T> ItemArrayLike<T>.firstOrNull(): T? =
	this.item(0)

inline fun <T> ItemArrayLike<T>.firstOrNull(predicate: (T) -> Boolean): T? {
	if (this.length < 1) return null

	for (i in 0 until this.length) {
		val it = item(i).unsafeCast<T>()
		if (predicate(it)) {
			return it
		}
	}
	return null
}

fun <T> ItemArrayLike<T>.toList(): List<T> =
	if (this.length > 0) {
		this.asList()
	} else {
		emptyList()
	}

fun <T> ItemArrayLike<T>.asSequence(): Sequence<T> =
	toList().asSequence()

inline fun <T> ItemArrayLike<T>.forEach(block: (item: T) -> Unit) =
	asList().forEach(block)