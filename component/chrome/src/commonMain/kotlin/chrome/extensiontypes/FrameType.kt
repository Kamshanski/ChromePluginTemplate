package chrome.extensiontypes

/**
 * The type of frame.
 * @since Chrome 106
 */
typealias FrameType = String

enum class FrameTypeEnum {

	outermost_frame,
	fenced_frame,
	sub_frame,
	;

	val value: FrameType = name

	companion object {

		fun enumValueOf(value: FrameType): FrameTypeEnum = FrameTypeEnum.valueOf(value)
	}
}