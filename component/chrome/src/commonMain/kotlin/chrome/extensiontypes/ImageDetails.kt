@file:JsQualifier("chrome.extensionTypes")

package chrome.extensiontypes

/** Details about the format and quality of an image. */
external interface ImageDetails {

	/** The format of the resulting image. Default is `"jpeg"`. */
	var format: ImageFormat?

	/** When format is `"jpeg"`, controls the quality of the resulting image. This value is ignored for PNG images. As quality is decreased, the resulting image will have more visual artifacts, and the number of bytes needed to store it will decrease. */
	var quality: Double?
}