package chrome.storage

import chrome.storage.constant.AccessLevelJsEnum

typealias AccessLevel = String

enum class AccessLevelEnum(private val valueProvider: AccessLevelJsEnum.() -> AccessLevel) {

	/** Specifies contexts originating from the extension itself. */
	TRUSTED_CONTEXTS({ TRUSTED_CONTEXTS }),

	/** Specifies contexts originating from outside the extension. */
	TRUSTED_AND_UNTRUSTED_CONTEXTS({ TRUSTED_AND_UNTRUSTED_CONTEXTS });

	val value: AccessLevel get() = valueProvider(AccessLevelJsEnum)

	companion object {

		fun enumValueOf(value: AccessLevel): AccessLevelEnum = valueOf(value)
	}
}