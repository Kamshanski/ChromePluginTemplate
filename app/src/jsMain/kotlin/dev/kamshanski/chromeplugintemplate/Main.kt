package dev.kamshanski.chromeplugintemplate

import dev.kamshanski.chromeplugintemplate.component.browserdocument.firstElementById
import dev.kamshanski.chromeplugintemplate.component.log.i
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.GlobalEventHandlers
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event

val header: HTMLHeadingElement get() = document.firstElementById("header")
val okButton: HTMLButtonElement get() = document.firstElementById("ok_button")
val numberInput: HTMLInputElement get() = document.firstElementById("number_input")

fun main() {
    window.onload = {
        i { "Extension default popup opened" }

        val originalHeaderText = header.textContent ?: ""

        okButton.setOnClickListener {
            val inputValue = numberInput.value.toIntOrNull()
            header.textContent = originalHeaderText + " " + inputValue
        }
    }
}

fun GlobalEventHandlers.setOnClickListener(listener: (event: Event) -> Unit) {
    this.onclick = {
        listener(it)
    }
}

