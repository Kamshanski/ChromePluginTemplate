package chrome.scripting

import chrome.scripting.constant.StyleOriginJsEnum

/** The origin for a style change. See style origins for more info. */
typealias StyleOrigin = String

/**
 * @see StyleOrigin
 */
enum class StyleOriginEnum(private val valueProvider: StyleOriginJsEnum.() -> StyleOrigin) {

	AUTHOR({ AUTHOR }),
	USER({ USER });

	val value: StyleOrigin get() = valueProvider(StyleOriginJsEnum)

	companion object {

		fun enumValueOf(value: StyleOrigin): StyleOriginEnum = valueOf(value)
	}
}