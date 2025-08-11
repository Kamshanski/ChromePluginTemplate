package chrome.runtime

external interface ManifestIcons {

	operator fun get(key: Int): String?

	operator fun set(key: Int, value: String?)
}