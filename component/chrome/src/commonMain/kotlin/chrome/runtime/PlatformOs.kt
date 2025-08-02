package chrome.runtime

/**
 * The operating system Chrome is running on.
 * @since Chrome 44
 */
typealias PlatformOs = String

enum class PlatformOsEnum {

	/** Specifies the MacOS operating system. */
	mac,

	/** Specifies the Windows operating system. */
	win,

	/** Specifies the Android operating system. */
	android,

	/** Specifies the Chrome operating system. */
	cros,

	/** Specifies the Linux operating system. */
	linux,

	/** Specifies the OpenBSD operating system. */
	openbsd,

	/** Specifies the Fuchsia operating system. */
	fuchsia,
	;

	val value: PlatformOs = name

	companion object {

		fun enumValueOf(value: PlatformOs): PlatformOsEnum = valueOf(value)
	}
}