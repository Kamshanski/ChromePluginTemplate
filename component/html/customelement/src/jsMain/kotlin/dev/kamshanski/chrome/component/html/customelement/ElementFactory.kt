package dev.kamshanski.chrome.component.html.customelement

import dev.kamshanski.chrome.component.log.i
import web.components.customElements
import web.dom.TagName
import web.html.HTMLElement
import kotlin.reflect.KClass

abstract class ElementFactory(
	tag: String,
	val klass: KClass<out HTMLElement>,
) {

	val tag = tag.lowercase()

	fun register() {
		customElements.define(TagName(tag), klass.js)
		i { "registered element $tag" }
	}
}