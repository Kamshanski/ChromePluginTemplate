package dev.kamshanski.chrome.component.html.customelement

import web.dom.Element

@JsExport
interface HtmlProvider {

	fun setupInnerHtml(element: Element, onSet: () -> Unit)
}