package chrome.extensiontypes

/**
 * The document lifecycle of the frame.
 * @since Chrome 106
 */
typealias DocumentLifecycle = String

/**
 * @see DocumentLifecycle
 */
enum class DocumentLifecycleEnum {

	prerender,
	active,
	cached,
	pending_deletion,
	;

	val value: DocumentLifecycle get() = name

	companion object {

		fun enumValueOf(value: DocumentLifecycle): DocumentLifecycleEnum = valueOf(value)
	}
}