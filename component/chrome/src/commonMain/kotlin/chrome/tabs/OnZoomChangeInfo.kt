package chrome.tabs

external interface OnZoomChangeInfo {

	var newZoomFactor: Double
	var oldZoomFactor: Double
	var tabId: Int
	var zoomSettings: ZoomSettings
}