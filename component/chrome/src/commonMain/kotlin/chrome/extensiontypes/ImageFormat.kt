package chrome.extensiontypes

/**
 * The format of an image.
 * @since Chrome 44
 */
typealias ImageFormat = String

enum class ImageFormatEnum {

	jpeg,
	png,
	;

	val value: RunAt = name

	companion object {

		fun enumValueOf(value: RunAt): RunAtEnum = RunAtEnum.valueOf(value)
	}
}