package chrome.runtime

import chrome.runtime.constant.PlatformNaclArchJsEnum

/**
 * The native client architecture. This may be different from arch on some platforms.
 * @since Chrome 44
 */
typealias PlatformNaclArch = String

enum class PlatformNaclArchEnum(private val valueProvider: PlatformNaclArchJsEnum.() -> PlatformNaclArch) {

	/** Specifies the native client architecture as arm. */
	ARM({ ARM }),

	/** Specifies the native client architecture as x86-32. */
	X86_32({ X86_32 }),

	/** Specifies the native client architecture as x86-64. */
	X86_64({ X86_64 }),

	/** Specifies the native client architecture as mips. */
	MIPS({ MIPS }),

	/** Specifies the native client architecture as mips64. */
	MIPS64({ MIPS64 });

	val value: PlatformNaclArch get() = valueProvider(PlatformNaclArchJsEnum)

	companion object {

		fun enumValueOf(value: PlatformNaclArch): PlatformNaclArchEnum = valueOf(value)
	}
}