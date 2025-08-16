package dev.kamshanski.chrome

import dev.kamshanski.chrome.component.html.customelement.CachedLocalHtmlContentProvider
import dev.kamshanski.chrome.component.html.customelement.CustomHtmlElement
import dev.kamshanski.chrome.component.html.customelement.ElementFactory
import dev.kamshanski.chrome.component.html.customelement.HtmlProvider
import dev.kamshanski.chrome.component.log.i
import kotlin.time.TimeSource.Monotonic.markNow

@OptIn(ExperimentalJsExport::class)
@JsExport
class MyCachedLocalHtmlElement : CustomHtmlElement() {

	companion object : ElementFactory("my-cached-html-rendered-component", MyCachedLocalHtmlElement::class) {

		private val provider = CachedLocalHtmlContentProvider(htmlPath = "element/my_cached_element.html")
	}
	private val t = markNow()

	override val htmlProvider: HtmlProvider = provider
	override fun onInnerHtmlSet() {
		i { "MyCachedLocalHtmlElement ${t.elapsedNow()}" }
	}
}

