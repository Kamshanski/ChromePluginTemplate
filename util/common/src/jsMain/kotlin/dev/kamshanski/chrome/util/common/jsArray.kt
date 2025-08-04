package dev.kamshanski.chrome.util.common

import kotlin.js.collections.JsReadonlyArray

inline fun <T> jsArrayOf(vararg args: T): JsReadonlyArray<T> =
	listOf(*args).asJsReadonlyArrayView()