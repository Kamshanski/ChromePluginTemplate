package dev.kamshanski.chromeplugintemplate.util.common

import kotlin.js.collections.JsReadonlyArray

fun <T> JsReadonlyArray<T>.asList(): List<T> {
	val array = this
	return object : AbstractList<T>() {
		override val size: Int
			get() {
				return array.asDynamic().length.unsafeCast<Int>()
			}

		override fun get(index: Int): T {
			return array.asDynamic().at(index).unsafeCast<T>()
		}
	}
}