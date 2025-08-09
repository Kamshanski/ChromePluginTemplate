package chrome.runtime

import chrome.runtime.constant.PlatformOsJsEnum

/**
 * The operating system Chrome is running on.
 * @since Chrome 44
 */
typealias PlatformOs = String

enum class PlatformOsEnum(private val valueProvider: PlatformOsJsEnum.() -> PlatformOs) {

	/** Specifies the MacOS operating system. */
	MAC({ MAC }),

	/** Specifies the Windows operating system. */
	WIN({ WIN }),

	/** Specifies the Android operating system. */
	ANDROID({ ANDROID }),

	/** Specifies the Chrome operating system. */
	CROS({ CROS }),

	/** Specifies the Linux operating system. */
	LINUX({ LINUX }),

	/** Specifies the OpenBSD operating system. */
	OPENBSD({ OPENBSD }),

	/** Specifies the Fuchsia operating system. */
	FUCHSIA({ FUCHSIA });

	val value: PlatformOs get() = valueProvider(PlatformOsJsEnum)

	companion object {

		fun enumValueOf(value: PlatformOs): PlatformOsEnum = valueOf(value)
	}
}