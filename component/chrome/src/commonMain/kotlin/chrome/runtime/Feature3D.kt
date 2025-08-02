@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface Feature3D {

	var features: JsReadonlyArray<String>?
}