package chrome.tabs

import chrome.extensiontypes.RunAt
import chrome.extensiontypes.RunAtEnum

/**
 * An event that caused a muted state change.
 * @since Chrome 46
 */
typealias MutedInfoReason = String

enum class MutedInfoReasonEnum {

	/** A user input action set the muted state. */
	user,

	/** Tab capture was started, forcing a muted state change. */
	capture,

	/** An extension set the muted state. */
	extension,
	;

	val value: RunAt = name

	companion object {

		fun enumValueOf(value: RunAt): RunAtEnum = RunAtEnum.valueOf(value)
	}
}