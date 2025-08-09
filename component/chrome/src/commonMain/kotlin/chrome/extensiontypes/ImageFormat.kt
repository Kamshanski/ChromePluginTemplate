package chrome.extensiontypes

/**
 * The format of an image.
 * @since Chrome 44
 */
typealias ImageFormat = String

enum class ImageFormatEnum() {

	jpeg,
	png,
	;

	val value: ImageFormat get() = name

	companion object {

		fun enumValueOf(value: ImageFormat): ImageFormatEnum = valueOf(value)
	}
}