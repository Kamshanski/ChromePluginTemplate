package dev.kamshanski.chrome.component.chrome.tabs

import chrome.tabs.QueryInfo

var QueryInfo.urlList: List<String>?
	get() = when (val u = url) {
		is String   -> listOf(u)
		is Array<*> -> u.filterIsInstance<String>()
		null        -> null
		else        -> throw ClassCastException("QueryInfo.url = $u")
	}
	set(value) {
		url = value
	}