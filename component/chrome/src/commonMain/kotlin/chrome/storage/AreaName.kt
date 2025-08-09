package chrome.storage

typealias AreaName = String /* keyof Pick<typeof chrome.storage, "sync" | "local" | "managed" | "session"> */

enum class AreaNameEnum {
	sync,
	local,
	managed,
	session,
	;

	val value: String get() = name
}