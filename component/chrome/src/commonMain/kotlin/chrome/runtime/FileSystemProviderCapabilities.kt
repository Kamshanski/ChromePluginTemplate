package chrome.runtime

external interface FileSystemProviderCapabilities {

	var configurable: Boolean?
	var watchable: Boolean?
	var multiple_mounts: Boolean?
	var source: String?
}