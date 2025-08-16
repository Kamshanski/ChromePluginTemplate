package dev.kamshanski.chrome.component.html.customelement

import chrome.runtime.ChromeRuntime
import kotlinx.browser.window
import web.dom.Element
import kotlin.js.Promise

class CachedLocalHtmlContentProvider(
	val htmlPath: String,
	preload: Boolean = true,
) : HtmlProvider {

	val request: Promise<Promise<String>> by lazy {
		val htmlUrl = ChromeRuntime.getURL(htmlPath)
		val promise = window.fetch(htmlUrl)
			.then(
				onFulfilled = { it.text() },
				onRejected = { throw it },
			)
		promise
	}

	init {
		if (preload) {
			request
		}
	}

	override fun setupInnerHtml(element: Element, onSet: () -> Unit) {
		request.then(
			onFulfilled = {
				element.innerHTML = it
				onSet()
			},
			onRejected = { throw it },
		)
	}
}