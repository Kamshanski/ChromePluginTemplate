package chrome.tabs

import chrome.tabs.constant.TabStatusJsEnum

/** The tab's loading status. */
typealias TabStatus = String

enum class TabStatusEnum(private val valueProvider: TabStatusJsEnum.() -> TabStatus) {

	UNLOADED({ UNLOADED }),

	LOADING({ LOADING }),

	COMPLETE({ COMPLETE }),
	;

	val value: TabStatus get() = valueProvider(TabStatusJsEnum)

	companion object {

		fun enumValueOf(value: TabStatus): TabStatusEnum = valueOf(value)
	}
}