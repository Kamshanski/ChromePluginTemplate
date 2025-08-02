package chrome.tabs

import chrome.extensiontypes.RunAt
import chrome.extensiontypes.RunAtEnum

/** The tab's loading status. */
typealias TabStatus = String

enum class TabStatusEnum {

	unloaded,
	loading,
	complete,
	;

	val value: RunAt = name

	companion object {

		fun enumValueOf(value: RunAt): RunAtEnum = RunAtEnum.valueOf(value)
	}
}