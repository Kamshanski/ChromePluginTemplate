package dev.kamshanski.chrome

import dev.kamshanski.chrome.component.html.customelement.CustomHtmlElement
import dev.kamshanski.chrome.component.html.customelement.ElementFactory
import dev.kamshanski.chrome.component.html.customelement.HtmlProvider
import dev.kamshanski.chrome.component.html.customelement.LocalHtmlContentProvider
import dev.kamshanski.chrome.component.log.i
import kotlin.time.TimeSource.Monotonic.markNow

@OptIn(ExperimentalJsExport::class)
@JsExport
class MyLocalHtmlElement : CustomHtmlElement() {

	companion object : ElementFactory("my-html-rendered-component", MyLocalHtmlElement::class) {

		private val provider = LocalHtmlContentProvider(htmlPath = "element/my_element.html")
	}

	private val t = markNow()

	override val htmlProvider: HtmlProvider = provider

	override fun onInnerHtmlSet() {
		i { "MyLocalHtmlElement ${t.elapsedNow()}" }
	}
}

