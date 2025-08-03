package dev.kamshanski.chrome

import dev.kamshanski.chrome.presentation.MainPresenter
import dev.kamshanski.chrome.presentation.MainState
import dev.kamshanski.chrome.presentation.VostorgState
import dev.kamshanski.chrome.utll.dom.firstElementById
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLParagraphElement

val urlInput: HTMLInputElement get() = document.firstElementById("url_input")
val patternInput: HTMLInputElement get() = document.firstElementById("pattern_input")
val replaceButton: HTMLButtonElement get() = document.firstElementById("replace_button")
val message: HTMLParagraphElement get() = document.firstElementById("message")

fun main() {
	val scope = MainScope()
	val mainPresenter = MainPresenter()
	window.onload = {
		mainPresenter.state
			.onEach { state -> updateState(state) }
			.launchIn(scope)

		urlInput.oninput = { event ->
			mainPresenter.setVostorgReplacement(urlInput.value)
		}
		patternInput.oninput = { event ->
			mainPresenter.setVostorgPattern(patternInput.value)
		}
		replaceButton.onclick = {
			mainPresenter.replaceEverywhere()
		}
	}
}

private fun updateState(state: MainState) {
	urlInput.value = state.vostorgReplacement
	patternInput.value = state.vostorgPattern

	when (val vostorgState = state.vostorgState) {
		is VostorgState.None      -> {
			setViewsAbility(false)
			message.textContent = ""
		}

		is VostorgState.Failed    -> {
			setViewsAbility(false)
			message.textContent = vostorgState.message ?: "Some error occured. See logs for more details"
		}

		is VostorgState.Replacing -> {
			setViewsAbility(true)
			message.textContent = ""
		}
	}
}

fun setViewsAbility(disabled: Boolean) {
	urlInput.disabled = disabled
	patternInput.disabled = disabled
	replaceButton.disabled = disabled
}