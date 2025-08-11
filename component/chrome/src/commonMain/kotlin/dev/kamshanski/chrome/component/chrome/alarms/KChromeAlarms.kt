package dev.kamshanski.chrome.component.chrome.alarms

import chrome.alarms.Alarm
import chrome.alarms.AlarmCreateInfo
import chrome.alarms.ChromeAlarms
import chrome.events.Event
import kotlinx.coroutines.await
import kotlin.js.collections.JsReadonlyArray

/**
 * Use the `chrome.alarms` API to schedule code to run periodically or at a specified time in the future.
 *
 * Permissions: "alarms"
 */
@Suppress("unused")
object KChromeAlarms {

	/**
	 * Creates an alarm. Near the time(s) specified by alarmInfo, the onAlarm event is fired. If there is another alarm with the same name (or no name if none is specified), it will be cancelled and replaced by this alarm.
	 * In order to reduce the load on the user's machine, Chrome limits alarms to at most once every 1 minute but may delay them an arbitrary amount more. That is, setting delayInMinutes or periodInMinutes to less than 1 will not be honored and will cause a warning. when can be set to less than 1 minute after "now" without warning but won't actually cause the alarm to fire for at least 1 minute.
	 * To help you debug your app or extension, when you've loaded it unpacked, there's no limit to how often the alarm can fire.
	 * @param alarmInfo Describes when the alarm should fire. The initial time must be specified by either when or delayInMinutes (but not both). If periodInMinutes is set, the alarm will repeat every periodInMinutes minutes after the initial event. If neither when or delayInMinutes is set for a repeating alarm, periodInMinutes is used as the default for delayInMinutes.
	 * @return The `create` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun create(alarmInfo: AlarmCreateInfo) = ChromeAlarms.create(alarmInfo).await()

	/**
	 * Creates an alarm. Near the time(s) specified by alarmInfo, the onAlarm event is fired. If there is another alarm with the same name (or no name if none is specified), it will be cancelled and replaced by this alarm.
	 * In order to reduce the load on the user's machine, Chrome limits alarms to at most once every 1 minute but may delay them an arbitrary amount more. That is, setting delayInMinutes or periodInMinutes to less than 1 will not be honored and will cause a warning. when can be set to less than 1 minute after "now" without warning but won't actually cause the alarm to fire for at least 1 minute.
	 * To help you debug your app or extension, when you've loaded it unpacked, there's no limit to how often the alarm can fire.
	 * @param name Optional name to identify this alarm. Defaults to the empty string.
	 * @param alarmInfo Describes when the alarm should fire. The initial time must be specified by either when or delayInMinutes (but not both). If periodInMinutes is set, the alarm will repeat every periodInMinutes minutes after the initial event. If neither when or delayInMinutes is set for a repeating alarm, periodInMinutes is used as the default for delayInMinutes.
	 * @return The `create` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun create(name: String, alarmInfo: AlarmCreateInfo) = ChromeAlarms.create(alarmInfo).await()

	/**
	 * Gets an array of all the alarms.
	 * @return The `getAll` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun getAll(): JsReadonlyArray<Alarm> = ChromeAlarms.getAll().await()

	/**
	 * Clears all alarms.
	 * function(boolean wasCleared) {...};
	 * @return The `clearAll` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun clearAll(): Boolean = ChromeAlarms.clearAll().await()

	/**
	 * Clears the alarm with the given name.
	 * @param name The name of the alarm to clear. Defaults to the empty string.
	 * @return The `clear` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun clear(name: String): Boolean = ChromeAlarms.clear(name).await()

	/**
	 * Clears the alarm without a name.
	 */
	suspend fun clear(): Boolean = ChromeAlarms.clear().await()

	/**
	 * Retrieves details about the specified alarm.
	 * @return The `get` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun get(): Alarm? = ChromeAlarms.get().await()

	/**
	 * Retrieves details about the specified alarm.
	 * @param name The name of the alarm to get. Defaults to the empty string.
	 * @return The `get` method provides its result via callback or returned as a `Promise` (MV3 only).
	 */
	suspend fun get(name: String): Alarm? = ChromeAlarms.get(name).await()

	/** Fired when an alarm has elapsed. Useful for event pages. */
	var onAlarm: Event<(alarm: Alarm) -> Unit> by ChromeAlarms::onAlarm
}