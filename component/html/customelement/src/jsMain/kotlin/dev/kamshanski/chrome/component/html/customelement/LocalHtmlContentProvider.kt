package dev.kamshanski.chrome.component.html.customelement

import chrome.runtime.ChromeRuntime
import kotlinx.browser.window
import web.dom.Element

class LocalHtmlContentProvider(
	val htmlPath: String,
) : HtmlProvider {

	override fun setupInnerHtml(element: Element, onSet: () -> Unit) {
		val htmlUrl = ChromeRuntime.getURL(htmlPath)

		window.fetch(htmlUrl)
			.then(
				onFulfilled = {
					it.text().then(
						onFulfilled = {
							element.innerHTML = it
							onSet()
						},
						onRejected = { throw it },
					)
				},
				onRejected = { throw it },
			)
	}
}