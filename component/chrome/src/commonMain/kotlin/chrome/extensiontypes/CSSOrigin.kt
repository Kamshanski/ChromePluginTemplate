package chrome.extensiontypes

/**
 * The origin of injected CSS.
 */
typealias CSSOrigin = String

/**
 * @see CSSOrigin
 */
enum class CSSOriginEnum() {

	author,
	user;

	val value: CSSOrigin = name

	companion object {

		fun enumValueOf(value: CSSOrigin): CSSOriginEnum = valueOf(value)
	}
}