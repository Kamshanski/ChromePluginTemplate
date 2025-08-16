package dev.kamshanski.chrome.component.html.customelement

import dev.kamshanski.chrome.component.log.i
import web.dom.Element
import kotlin.time.TimeSource.Monotonic.markNow

class InstantHtmlProvider(
	val html: String,
) : HtmlProvider {

	val t = markNow()

	override fun setupInnerHtml(element: Element, onSet: () -> Unit) {
		element.innerHTML = html
		i { "InstantHtmlProvider ${t.elapsedNow()}" }
	}
}