package chrome.runtime

import chrome.runtime.constant.PlatformArchJsEnum

/**
 * The machine's processor architecture.
 * @since Chrome 44
 */
typealias PlatformArch = String

enum class PlatformArchEnum(private val valueProvider: PlatformArchJsEnum.() -> PlatformArch) {

	/** Specifies the processer architecture as arm. */
	ARM({ ARM }),

	/** Specifies the processer architecture as arm64. */
	ARM64({ ARM64 }),

	/** Specifies the processer architecture as x86-32. */
	X86_32({ X86_32 }),

	/** Specifies the processer architecture as x86-64. */
	X86_64({ X86_64 }),

	/** Specifies the processer architecture as mips. */
	MIPS({ MIPS }),

	/** Specifies the processer architecture as mips64. */
	MIPS64({ MIPS64 });

	val value: PlatformArch get() = valueProvider(PlatformArchJsEnum)

	companion object {

		fun enumValueOf(value: PlatformArch): PlatformArchEnum = valueOf(value)
	}
}