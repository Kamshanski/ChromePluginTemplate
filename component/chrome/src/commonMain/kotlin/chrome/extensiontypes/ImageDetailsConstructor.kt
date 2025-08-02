package chrome.extensiontypes

fun ImageDetails(
	/** The format of the resulting image. Default is `"jpeg"`. */
	format: ImageFormat = ImageFormatEnum.jpeg.value,
	/** When format is `"jpeg"`, controls the quality of the resulting image. This value is ignored for PNG images. As quality is decreased, the resulting image will have more visual artifacts, and the number of bytes needed to store it will decrease. */
	quality: Double? = null,
): ImageDetails =
	js("{}").unsafeCast<ImageDetails>().apply {
		this.format = format
		this.quality = quality
	}