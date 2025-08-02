package chrome

external interface SetIconOptions {

	@Deprecated("Use extension with specified type", replaceWith = ReplaceWith("imageDataMap"))
	var imageData: Any? /* ImageData | { [size: string]: ImageData; } | undefined */
}