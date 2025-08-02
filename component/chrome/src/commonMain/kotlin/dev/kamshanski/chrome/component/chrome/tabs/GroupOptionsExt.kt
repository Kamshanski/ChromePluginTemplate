package dev.kamshanski.chrome.component.chrome.tabs

import chrome.tabs.GroupOptions

var GroupOptions.tabIdList: List<Int>?
	get() = when (val tabIds = tabIds) {
		is Int      -> listOf(tabIds)
		is IntArray -> tabIds.toList()
		null        -> null
		else        -> throw ClassCastException("GroupOptions.tabIds = $tabIds")
	}
	set(value) {
		tabIds = value
	}