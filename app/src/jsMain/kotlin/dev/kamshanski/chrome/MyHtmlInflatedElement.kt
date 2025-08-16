package dev.kamshanski.chrome

import dev.kamshanski.chrome.component.html.customelement.CustomHtmlInflatedElement
import dev.kamshanski.chrome.component.html.customelement.ElementFactory

@OptIn(ExperimentalJsExport::class)
@JsExport
class MyHtmlInflatedElement : CustomHtmlInflatedElement() {

	companion object : ElementFactory("my-html-rendered-component", MyHtmlInflatedElement::class)

	override val htmlPagePath: String = "element/my_element.html"

	override fun onHtmlContentLoaded() {
	}
}

