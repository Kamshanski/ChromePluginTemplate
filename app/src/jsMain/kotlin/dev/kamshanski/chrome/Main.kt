package dev.kamshanski.chrome

import dev.kamshanski.chrome.component.chrome.bookmarks.KChromeBookmarks
import dev.kamshanski.chrome.component.chrome.bookmarks.childList
import dev.kamshanski.chrome.component.chrome.bookmarks.findBookmarksBarNodeOrNull
import dev.kamshanski.chrome.component.chrome.bookmarks.isFile
import dev.kamshanski.chrome.component.log.i
import dev.kamshanski.chrome.test.ConstantsTest
import dev.kamshanski.chrome.utll.w3c.dom.firstElementById
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.w3c.dom.GlobalEventHandlers
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLParagraphElement
import org.w3c.dom.events.Event

val header: HTMLHeadingElement get() = document.firstElementById("header")
val okButton: HTMLButtonElement get() = document.firstElementById("ok_button")
val numberInput: HTMLInputElement get() = document.firstElementById("number_input")
val bookmarksCountButton: HTMLButtonElement get() = document.firstElementById("bookmarks_count_button")
val bookmarksCountResult: HTMLParagraphElement get() = document.firstElementById("bookmarks_count_result")
val enumTestButton: HTMLButtonElement get() = document.firstElementById("enum_test_button")
val enumTestResult: HTMLParagraphElement get() = document.firstElementById("enum_test_result")

fun main() {
	i { "Extension script loaded" }

	val scope = MainScope()
	window.onload = {
		i { "Extension default popup opened" }

		val originalHeaderText = header.textContent ?: ""

		okButton.setOnClickListener {
			val inputValue = numberInput.value.toIntOrNull()
			header.textContent = originalHeaderText + " " + inputValue
		}

		bookmarksCountButton.setOnClickListener {
			scope.launch {
				with(KChromeBookmarks) {
					val root = getTree().first()
					val bookmarksBar = root.findBookmarksBarNodeOrNull()
					val files = bookmarksBar?.childList?.filter { it.isFile } ?: error("No files found")

					val count = files.count()
					val item = files.random()

					bookmarksCountResult.textContent = "Вне папок находится $count закладок. Рандомная - ${item.title}"
				}
			}
		}
		enumTestButton.setOnClickListener {
			val result = ConstantsTest().test()
			val message = if (result.isEmpty()) {
				"Всё круто"
			} else {
				result.joinToString("<br>") {
					when (it) {
						is ConstantsTest.Error.MismatchedValue     -> it.entry.name + " != " + it.chromeValue

						is ConstantsTest.Error.NotFoundValueOrEnum -> it.entry::class.simpleName + "." + it.entry.name + " not found. ${it.e ?: ""}"
					}
				}
			}
			enumTestResult.innerHTML = message
		}
	}
}

fun GlobalEventHandlers.setOnClickListener(listener: (event: Event) -> Unit) {
	this.onclick = {
		listener(it)
	}
}

