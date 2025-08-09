package chrome.tabs

import chrome.extensiontypes.RunAt
import chrome.extensiontypes.RunAtEnum
import chrome.tabs.constant.MutedInfoReasonJsEnum

/**
 * An event that caused a muted state change.
 * @since Chrome 46
 */
typealias MutedInfoReason = String

enum class MutedInfoReasonEnum(private val valueProvider: MutedInfoReasonJsEnum.() -> MutedInfoReason) {

	/** A user input action set the muted state. */
	USER({ USER }),

	/** Tab capture was started, forcing a muted state change. */
	CAPTURE({ CAPTURE }),

	/** An extension set the muted state. */
	EXTENSION({ EXTENSION }),
	;

	val value: MutedInfoReason get() = valueProvider(MutedInfoReasonJsEnum)

	companion object {

		fun enumValueOf(value: RunAt): RunAtEnum = RunAtEnum.entries.first { it.value == value }
	}
}