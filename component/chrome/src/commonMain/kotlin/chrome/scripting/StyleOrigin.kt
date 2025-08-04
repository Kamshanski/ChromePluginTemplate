package chrome.scripting

/** The origin for a style change. See style origins for more info. */
typealias StyleOrigin = String

/**
 * @see StyleOrigin
 */
enum class StyleOriginEnum {

	AUTHOR,
	USER,
	;

	val value: StyleOrigin = name.lowercase()

	companion object {

		fun enumValueOf(value: StyleOrigin): StyleOriginEnum = valueOf(value)
	}
}