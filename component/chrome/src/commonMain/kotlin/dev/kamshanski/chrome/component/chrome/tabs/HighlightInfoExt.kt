package dev.kamshanski.chrome.component.chrome.tabs

import chrome.tabs.HighlightInfo

var HighlightInfo.tabsArray: List<Int>
	get() = when (val t = tabs) {
		is Int      -> listOf(t)
		is IntArray -> t.toList()
		else        -> throw ClassCastException("HighlightInfo.tabs = $t")
	}
	set(value) {
		tabs = value.toTypedArray()
	}