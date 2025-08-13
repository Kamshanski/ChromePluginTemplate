package dev.kamshanski.chrome.component.chrome.alarms

import chrome.alarms.AlarmCreateInfo

/**
 * @see chrome.alarms.ChromeAlarms.create
 * @see AlarmCreateInfo
 */
suspend fun KChromeAlarms.create(
	delayInMinutes: Double? = null,
	periodInMinutes: Double? = null,
	`when`: Int? = null,
) = create(
	AlarmCreateInfo(
		delayInMinutes = delayInMinutes,
		periodInMinutes = periodInMinutes,
		`when` = `when`,
	)
)

/**
 * @see chrome.alarms.ChromeAlarms.create
 * @see AlarmCreateInfo
 */
suspend fun KChromeAlarms.create(
	name: String,
	delayInMinutes: Double? = null,
	periodInMinutes: Double? = null,
	`when`: Int? = null,
) = create(
	name = name,
	AlarmCreateInfo(
		delayInMinutes = delayInMinutes,
		periodInMinutes = periodInMinutes,
		`when` = `when`,
	)
)