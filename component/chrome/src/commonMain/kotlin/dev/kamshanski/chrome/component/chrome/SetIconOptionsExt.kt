package dev.kamshanski.chrome.component.chrome

import chrome.SetIconOptions
import org.w3c.dom.ImageData
import kotlin.js.collections.JsMap
import kotlin.js.collections.toMap

var SetIconOptions.imageDataMap: Map<String, ImageData>?
	get() = when (val data = imageData) {
		is ImageData   -> mapOf<String, ImageData>("default" to data)
		is JsMap<*, *> -> data.toMap() as Map<String, ImageData>
		null           -> null
		else           -> throw ClassCastException("SetIconOptions.imageData = $data")
	}
	set(value) {
		imageData = value
	}