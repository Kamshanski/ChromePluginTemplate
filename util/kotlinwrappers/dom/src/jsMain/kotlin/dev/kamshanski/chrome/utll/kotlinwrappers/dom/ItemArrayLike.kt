package dev.kamshanski.chrome.utll.kotlinwrappers.dom

import js.array.asList
import web.dom.Element
import web.html.HTMLCollection

fun HTMLCollection<*>.isEmpty(): Boolean = length == 0

fun <T : Element> HTMLCollection<T>.first(): T =
	firstOrNull() ?: error("No first element in collection")

fun <T : Element> HTMLCollection<T>.firstOrNull(): T? =
	this.item(0)

inline fun <T : Element> HTMLCollection<T>.firstOrNull(predicate: (T) -> Boolean): T? {
	if (this.length < 1) return null

	for (i in 0 until this.length) {
		val it = item(i).unsafeCast<T>()
		if (predicate(it)) {
			return it
		}
	}
	return null
}

fun <T : Element> HTMLCollection<T>.asSequence(): Sequence<T> =
	asList().asSequence()

inline fun <T : Element> HTMLCollection<T>.forEach(block: (item: T) -> Unit) =
	asList().forEach(block)