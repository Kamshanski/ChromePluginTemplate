package dev.kamshanski.chrome.component.chrome.alarms

import chrome.alarms.Alarm
import chrome.alarms.AlarmCreateInfo
import chrome.alarms.ChromeAlarms
import chrome.events.Event
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await

/** @see ChromeAlarms */
interface KChromeAlarms {

	companion object : KChromeAlarms {

		/** @see ChromeAlarms.onAlarm */
		override var onAlarm: Event<(alarm: Alarm) -> Unit> by ChromeAlarms::onAlarm

		/** @see ChromeAlarms.create */
		override suspend fun create(alarmInfo: AlarmCreateInfo) = ChromeAlarms.create(alarmInfo).await()

		/** @see ChromeAlarms.create */
		override suspend fun create(name: String, alarmInfo: AlarmCreateInfo) = ChromeAlarms.create(alarmInfo).await()

		/** @see ChromeAlarms.getAll */
		override suspend fun getAll(): List<Alarm> = ChromeAlarms.getAll().await().asList()

		/** @see ChromeAlarms.clearAll */
		override suspend fun clearAll(): Boolean = ChromeAlarms.clearAll().await()

		/** @see ChromeAlarms.clear */
		override suspend fun clear(name: String): Boolean = ChromeAlarms.clear(name).await()

		/** @see ChromeAlarms.clear */
		override suspend fun clear(): Boolean = ChromeAlarms.clear().await()

		/** @see ChromeAlarms.get */
		override suspend fun get(): Alarm? = ChromeAlarms.get().await()

		/** @see ChromeAlarms.get */
		override suspend fun get(name: String): Alarm? = ChromeAlarms.get(name).await()
	}

	/** @see ChromeAlarms.onAlarm */
	var onAlarm: Event<(alarm: Alarm) -> Unit>

	/** @see ChromeAlarms.create */
	suspend fun create(alarmInfo: AlarmCreateInfo)

	/** @see ChromeAlarms.create */
	suspend fun create(name: String, alarmInfo: AlarmCreateInfo)

	/** @see ChromeAlarms.getAll */
	suspend fun getAll(): List<Alarm>

	/** @see ChromeAlarms.clearAll */
	suspend fun clearAll(): Boolean

	/** @see ChromeAlarms.clear */
	suspend fun clear(name: String): Boolean

	/** @see ChromeAlarms.clear */
	suspend fun clear(): Boolean

	/** @see ChromeAlarms.get */
	suspend fun get(): Alarm?

	/** @see ChromeAlarms.get */
	suspend fun get(name: String): Alarm?
}