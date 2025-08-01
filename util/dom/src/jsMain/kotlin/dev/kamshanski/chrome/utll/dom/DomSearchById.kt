package dev.kamshanski.chrome.utll.dom

import org.w3c.dom.Document
import org.w3c.dom.Element

inline fun <reified V : Element> Document.firstElementById(id: String): V {
	return firstElementByIdOrNull<V>(id) ?: error("firstElementById($id) failed to find element")
}

inline fun <reified V : Element> Document.firstElementByIdOrNull(id: String): V? {
	val e = getElementById(id) ?: return null
	return e.unsafeCast<V>()
}
