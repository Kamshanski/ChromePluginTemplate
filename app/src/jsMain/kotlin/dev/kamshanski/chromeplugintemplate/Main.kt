package dev.kamshanski.chromeplugintemplate

import dev.kamshanski.chromeplugintemplate.component.log.i
import kotlinx.browser.window

fun main() {
    window.onload = {
        i { "Extension default popup opened" }
    }
}
