package dev.kamshanski.chrome.component.html.customelement

import web.components.CustomElement
import web.html.HTMLElement

abstract class CustomHtmlElement : HTMLElement, CustomElement.WithConnectedCallback {
	constructor() : super()

	abstract fun loadContent()

	final override fun connectedCallback() {
		loadContent()
	}
}