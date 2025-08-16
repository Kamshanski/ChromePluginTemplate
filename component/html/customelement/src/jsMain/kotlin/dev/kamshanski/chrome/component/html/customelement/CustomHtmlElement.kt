package dev.kamshanski.chrome.component.html.customelement

import web.components.CustomElement
import web.html.HTMLElement

abstract class CustomHtmlElement : HTMLElement, CustomElement.WithConnectedCallback {
	constructor() : super()

	protected abstract val htmlProvider: HtmlProvider

	final override fun connectedCallback() {
		loadContent()
	}

	private fun loadContent() {
		htmlProvider.setupInnerHtml(this) {
			onInnerHtmlSet()
		}
	}

	open fun onInnerHtmlSet() {}
}