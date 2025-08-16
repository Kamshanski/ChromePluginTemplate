package dev.kamshanski.chrome.utll.kotlinwrappers.dom

import web.dom.Document
import web.dom.Element
import web.dom.ElementId

inline fun <reified V : Element> Document.firstElementById(id: String): V {
	return firstElementByIdOrNull<V>(id) ?: error("firstElementById($id) failed to find element")
}

inline fun <reified V : Element> Document.firstElementByIdOrNull(id: String): V? {
	val e = getElementById(ElementId(id)) ?: return null
	return e.unsafeCast<V>()
}
