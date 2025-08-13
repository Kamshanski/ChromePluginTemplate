package chrome.runtime

external interface Commands {

	operator fun get(key: String): Command?

	operator fun set(key: String, value: Command?)
}