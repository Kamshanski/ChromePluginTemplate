package chrome.extensiontypes

typealias CSSOrigin = String

/**
 * @see CSSOrigin
 */
enum class CSSOriginEnum {

	author,
	user,
	;

	val value: CSSOrigin = name

	companion object {

		fun enumValueOf(value: CSSOrigin): CSSOriginEnum = valueOf(value)
	}
}