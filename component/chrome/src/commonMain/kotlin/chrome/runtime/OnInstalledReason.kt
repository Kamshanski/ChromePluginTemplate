package chrome.runtime

import chrome.runtime.constant.OnInstalledReasonJsEnum

/**
 * The reason that this event is being dispatched.
 * @since Chrome 44
 */
typealias OnInstalledReason = String

enum class OnInstalledReasonEnum(private val valueProvider: OnInstalledReasonJsEnum.() -> OnInstalledReason) {

	/** Specifies the event reason as an installation. */
	INSTALL({ INSTALL }),

	/** Specifies the event reason as an extension update. */
	UPDATE({ UPDATE }),

	/** Specifies the event reason as a Chrome update. */
	CHROME_UPDATE({ CHROME_UPDATE }),

	/** Specifies the event reason as an update to a shared module. */
	SHARED_MODULE_UPDATE({ SHARED_MODULE_UPDATE });

	val value: OnInstalledReason get() = valueProvider(OnInstalledReasonJsEnum)

	companion object {

		fun enumValueOf(value: OnInstalledReason): OnInstalledReasonEnum = valueOf(value)
	}
}