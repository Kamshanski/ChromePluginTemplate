package chrome.runtime

/**
 * The machine's processor architecture.
 * @since Chrome 44
 */
typealias PlatformArch = String

enum class PlatformArchEnum {

	/** Specifies the processer architecture as arm. */
	arm,

	/** Specifies the processer architecture as arm64. */
	arm64,

	/** Specifies the processer architecture as x86-32. */
	`x86-32`,

	/** Specifies the processer architecture as x86-64. */
	`x86-64`,

	/** Specifies the processer architecture as mips. */
	mips,

	/** Specifies the processer architecture as mips64. */
	mips64,

	/** Specifies the processer architecture as riscv64. */
	riscv64,
	;

	val value: PlatformArch = name

	companion object {

		fun enumValueOf(value: PlatformArch): PlatformArchEnum = valueOf(value)
	}
}