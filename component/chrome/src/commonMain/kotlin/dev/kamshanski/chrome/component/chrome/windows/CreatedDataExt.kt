package dev.kamshanski.chrome.component.chrome.windows

import chrome.windows.CreateData

var CreateData.urlList: List<String>?
	get() = when (val u = url) {
		is String   -> listOf(u)
		is Array<*> -> u.filterIsInstance<String>()
		null        -> null
		else        -> throw ClassCastException("CreateData.url = $u")
	}
	set(value) {
		url = value
	}