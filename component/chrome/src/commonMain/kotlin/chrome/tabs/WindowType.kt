package chrome.tabs

import chrome.extensiontypes.RunAt
import chrome.extensiontypes.RunAtEnum

typealias WindowType = String

/** The type of window. */
enum class WindowTypeEnum {

	normal,
	popup,
	panel,
	app,
	devtools,
	;

	val value: RunAt = name

	companion object {

		fun enumValueOf(value: RunAt): RunAtEnum = RunAtEnum.valueOf(value)
	}
}