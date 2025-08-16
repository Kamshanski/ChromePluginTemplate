package dev.kamshanski.chrome

import dev.kamshanski.chrome.component.html.customelement.CustomHtmlElement
import dev.kamshanski.chrome.component.html.customelement.ElementFactory

@OptIn(ExperimentalJsExport::class)
@JsExport
class MyHtmlElement : CustomHtmlElement() {

	companion object : ElementFactory("my-html-component", MyHtmlElement::class)

	override fun loadContent() {
		innerHTML = """
			<div>
                <slot name="title">Text from string</slot>
			</div>
		"""
	}
}