package dev.kamshanski.chrome.util.common

inline fun <T, reified R> List<T>.mapToArray(block: (T) -> R): Array<R> =
	Array(size) { get(it).let(block) }
