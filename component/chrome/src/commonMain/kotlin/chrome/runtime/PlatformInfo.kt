package chrome.runtime

/** An object containing information about the current platform. */
external interface PlatformInfo {

	/** The operating system Chrome is running on. */
	var os: PlatformOs

	/** The machine's processor architecture. */
	var arch: PlatformArch

	/** The native client architecture. This may be different from arch on some platforms. */
	var nacl_arch: PlatformNaclArch
}