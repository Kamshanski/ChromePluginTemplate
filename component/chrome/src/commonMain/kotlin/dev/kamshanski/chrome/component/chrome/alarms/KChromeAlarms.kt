package dev.kamshanski.chrome.component.chrome.alarms

import chrome.alarms.Alarm
import chrome.alarms.AlarmCreateInfo
import chrome.alarms.ChromeAlarms
import chrome.events.Event
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await

@Suppress("unused")
interface KChromeAlarms {

	companion object : KChromeAlarms {

		override var onAlarm: Event<(alarm: Alarm) -> Unit> by ChromeAlarms::onAlarm

		override suspend fun create(alarmInfo: AlarmCreateInfo) = ChromeAlarms.create(alarmInfo).await()

		override suspend fun create(name: String, alarmInfo: AlarmCreateInfo) = ChromeAlarms.create(alarmInfo).await()

		override suspend fun getAll(): List<Alarm> = ChromeAlarms.getAll().await().asList()

		override suspend fun clearAll(): Boolean = ChromeAlarms.clearAll().await()

		override suspend fun clear(name: String): Boolean = ChromeAlarms.clear(name).await()

		override suspend fun clear(): Boolean = ChromeAlarms.clear().await()

		override suspend fun get(): Alarm? = ChromeAlarms.get().await()

		override suspend fun get(name: String): Alarm? = ChromeAlarms.get(name).await()
	}

	var onAlarm: Event<(alarm: Alarm) -> Unit>

	suspend fun create(alarmInfo: AlarmCreateInfo)

	suspend fun create(name: String, alarmInfo: AlarmCreateInfo)

	suspend fun getAll(): List<Alarm>

	suspend fun clearAll(): Boolean

	suspend fun clear(name: String): Boolean

	suspend fun clear(): Boolean

	suspend fun get(): Alarm?

	suspend fun get(name: String): Alarm?
}