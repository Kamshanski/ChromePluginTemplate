package dev.kamshanski.chrome.component.chrome.runtime

import chrome.runtime.InputComponent

var InputComponent.languageList: List<String>?
	get() = when (val l = language) {
		is String -> listOf(l)
		is Array<*> -> l.filterIsInstance<String>()
		null -> null
		else -> throw ClassCastException("InputComponent.language = $l")
	}
	set(value) {
		language = value
	}