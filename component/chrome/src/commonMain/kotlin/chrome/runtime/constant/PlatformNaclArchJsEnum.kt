@file:JsQualifier("chrome.runtime")

package chrome.runtime.constant

import chrome.runtime.PlatformNaclArch

@JsName("PlatformNaclArch")
internal external object PlatformNaclArchJsEnum {

	val ARM: PlatformNaclArch
	val X86_32: PlatformNaclArch
	val X86_64: PlatformNaclArch
	val MIPS: PlatformNaclArch
	val MIPS64: PlatformNaclArch
	val RISCV64: PlatformNaclArch
}