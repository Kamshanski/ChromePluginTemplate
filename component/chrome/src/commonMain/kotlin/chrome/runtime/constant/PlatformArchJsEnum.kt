@file:JsQualifier("chrome.runtime")

package chrome.runtime.constant

import chrome.runtime.PlatformArch

@JsName("PlatformArch")
internal external object PlatformArchJsEnum {

	val ARM: PlatformArch
	val ARM64: PlatformArch
	val X86_32: PlatformArch
	val X86_64: PlatformArch
	val MIPS: PlatformArch
	val MIPS64: PlatformArch
	val RISCV64: PlatformArch
}