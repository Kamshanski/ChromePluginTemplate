package dev.kamshanski.chrome.util.common

import kotlin.js.Json
import kotlin.js.collections.JsReadonlyArray

@ExperimentalJsUtils
val Json.keys: List<String>
	get() {
		val obj = this
		return js("Object.keys(obj)").unsafeCast<JsReadonlyArray<String>>().asList()
	}

@ExperimentalJsUtils
val Json.values: List<Any?>
	get() {
		val obj = this
		return js("Object.values(obj)").unsafeCast<JsReadonlyArray<Any?>>().asList()
	}

@ExperimentalJsUtils
operator fun Json.iterator(): Iterator<Map.Entry<String, Any?>> {
	val obj = this
	val iterator: JsIterator = js("obj[Symbol.iterator]()")
	return iterator {
		var it: IteratorResult = iterator.next()
		while (it.done == false) {
			val entry = object : Map.Entry<String, Any?> {
				override val key: String = it.value.asDynamic().at(0)
				override val value: Any? = it.value.asDynamic().at(1)
			}
			yield(entry)
			it = iterator.next()
		}
	}
}

private external interface JsIterator {

	fun next(): IteratorResult
}

private external interface IteratorResult {

	var done: Boolean
	var value: Any?
}

private inline fun DoneIteratorResult(): IteratorResult =
	js("{}").unsafeCast<IteratorResult>().apply {
		this.done = true
	}

private inline fun UndoneIteratorResult(value: Any?): IteratorResult =
	js("{}").unsafeCast<IteratorResult>().apply {
		this.done = true
		this.value = value
	}