package chrome.runtime

/**
 * The reason that this event is being dispatched.
 * @since Chrome 44
 */
typealias OnInstalledReason = String

enum class OnInstalledReasonEnum {

	/** Specifies the event reason as an installation. */
	install,

	/** Specifies the event reason as an extension update. */
	update,

	/** Specifies the event reason as a Chrome update. */
	chrome_update,

	/** Specifies the event reason as an update to a shared module. */
	shared_module_update,
	;

	val value: OnInstalledReason = name

	companion object {

		fun enumValueOf(value: OnInstalledReason): OnInstalledReasonEnum = valueOf(value)
	}
}