package chrome.runtime

import chrome.runtime.constant.RequestUpdateCheckStatusJsEnum

/**
 * Result of the update check.
 * @since Chrome 44
 */
typealias RequestUpdateCheckStatus = String

enum class RequestUpdateCheckStatusEnum(private val valueProvider: RequestUpdateCheckStatusJsEnum.() -> RequestUpdateCheckStatus) {

	/** Specifies that the status check has been throttled. This can occur after repeated checks within a short amount of time. */
	THROTTLED({ THROTTLED }),

	/** Specifies that there are no available updates to install. */
	NO_UPDATE({ NO_UPDATE }),

	/** Specifies that there is an available update to install. */
	UPDATE_AVAILABLE({ UPDATE_AVAILABLE });

	val value: RequestUpdateCheckStatus get() = valueProvider(RequestUpdateCheckStatusJsEnum)

	companion object {

		fun enumValueOf(value: RequestUpdateCheckStatus): RequestUpdateCheckStatusEnum = valueOf(value)
	}
}