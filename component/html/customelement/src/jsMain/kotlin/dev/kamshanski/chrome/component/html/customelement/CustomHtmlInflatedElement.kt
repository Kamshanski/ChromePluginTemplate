package dev.kamshanski.chrome.component.html.customelement

import chrome.runtime.ChromeRuntime
import kotlinx.browser.window
import web.components.CustomElement

abstract class CustomHtmlInflatedElement : CustomHtmlElement, CustomElement.WithConnectedCallback {
	constructor() : super()

	abstract val htmlPagePath: String

	override fun loadContent() {
		val htmlUrl = ChromeRuntime.getURL(htmlPagePath)

		inflate(htmlUrl)
	}

	private fun inflate(htmlUrl: String) {
		window.fetch(htmlUrl)
			.then(
				onFulfilled = {
					it.text().then(
						onFulfilled = {
							this@CustomHtmlInflatedElement.innerHTML = it
							onHtmlContentLoaded()
						},
						onRejected = { throw it },
					)
				},
				onRejected = { throw it },
			)
	}

	abstract fun onHtmlContentLoaded()
}