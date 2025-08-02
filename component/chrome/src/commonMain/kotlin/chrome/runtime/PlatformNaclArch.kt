package chrome.runtime

/**
 * The native client architecture. This may be different from arch on some platforms.
 * @since Chrome 44
 */
typealias PlatformNaclArch = String

enum class PlatformNaclArchEnum {

	/** Specifies the native client architecture as arm. */
	arm,

	/** Specifies the native client architecture as x86-32. */
	`x86-32`,

	/** Specifies the native client architecture as x86-64. */
	`x86-64`,

	/** Specifies the native client architecture as mips. */
	mips,

	/** Specifies the native client architecture as mips64. */
	mips64,

	/** Specifies the native client architecture as riscv64. */
	riscv64,
	;

	val value: PlatformNaclArch = name

	companion object {

		fun enumValueOf(value: PlatformNaclArch): PlatformNaclArchEnum = valueOf(value)
	}
}