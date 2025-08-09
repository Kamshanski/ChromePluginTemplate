@file:JsQualifier("chrome.alarms")

package chrome.alarms

external interface Alarm {

	/** Optional. If not null, the alarm is a repeating alarm and will fire again in periodInMinutes minutes.  */
	var periodInMinutes: Double?

	/** Time at which this alarm was scheduled to fire, in milliseconds past the epoch (e.g. Date.now() + n). For performance reasons, the alarm may have been delayed an arbitrary amount beyond this. */
	var scheduledTime: Double

	/** Name of this alarm. */
	var name: String
}