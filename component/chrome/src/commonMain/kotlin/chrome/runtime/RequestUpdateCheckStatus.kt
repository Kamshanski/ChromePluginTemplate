package chrome.runtime

/**
 * Result of the update check.
 * @since Chrome 44
 */
typealias RequestUpdateCheckStatus = String

enum class RequestUpdateCheckStatusEnum {

	/** Specifies that the status check has been throttled. This can occur after repeated checks within a short amount of time. */
	throttled,

	/** Specifies that there are no available updates to install. */
	no_update,

	/** Specifies that there is an available update to install. */
	update_available;

	val value: RequestUpdateCheckStatus = name

	companion object {

		fun enumValueOf(value: RequestUpdateCheckStatus): RequestUpdateCheckStatusEnum = valueOf(value)
	}
}