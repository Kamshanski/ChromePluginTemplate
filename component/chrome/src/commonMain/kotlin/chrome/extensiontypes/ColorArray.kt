package chrome.extensiontypes

import kotlin.js.collections.JsReadonlyArray

/**
 * n array of four integers in the range 0-255, defining an RGBA color. The four values specify the following channels:
 * 1. Red
 * 2. Green
 * 3. Blue
 * 4. Alpha (opacity).
 *
 * For example, opaque red is [255, 0, 0, 255].
 */
typealias ColorArray = JsReadonlyArray<Int>

fun ColorArray(r: Int, g: Int, b: Int, alpha: Int): ColorArray =
	js("[r, g, b, alpha]")