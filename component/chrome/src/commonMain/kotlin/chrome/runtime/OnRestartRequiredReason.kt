package chrome.runtime

/**
 * The reason that the event is being dispatched. 'app_update' is used when the restart is needed because the application is updated to a newer version. 'os_update' is used when the restart is needed because the browser/OS is updated to a newer version. 'periodic' is used when the system runs for more than the permitted uptime set in the enterprise policy.
 * @since Chrome 44
 */
typealias OnRestartRequiredReason = String

enum class OnRestartRequiredReasonEnum {

	/** Specifies the event reason as an update to the app. */
	app_update,

	/** Specifies the event reason as an update to the operating system. */
	os_update,

	/** Specifies the event reason as a periodic restart of the app. */
	periodic;

	val value: OnRestartRequiredReason = name

	companion object {

		fun enumValueOf(value: OnRestartRequiredReason): OnRestartRequiredReasonEnum = valueOf(value)
	}
}