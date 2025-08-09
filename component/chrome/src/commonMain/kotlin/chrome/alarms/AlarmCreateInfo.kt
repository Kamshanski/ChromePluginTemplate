@file:JsQualifier("chrome.alarms")

package chrome.alarms

external interface AlarmCreateInfo {

	/** Optional. Length of time in minutes after which the onAlarm event should fire.  */
	var delayInMinutes: Double?

	/** Optional. If set, the onAlarm event should fire every periodInMinutes minutes after the initial event specified by when or delayInMinutes. If not set, the alarm will only fire once.  */
	var periodInMinutes: Double?

	/** Optional. Time at which the alarm should fire, in milliseconds past the epoch (e.g. Date.now() + n).  */
	var `when`: Int?
}