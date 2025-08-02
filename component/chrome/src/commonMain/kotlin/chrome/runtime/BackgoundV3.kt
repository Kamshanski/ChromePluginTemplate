@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface BackgoundV3 {

	var service_worker: String
	var type: String?/* "module" */ // If the service worker uses ES modules
}