@file:JsQualifier("chrome.windows")

package chrome.windows

import kotlin.js.collections.JsReadonlyArray

external interface WindowsEventAddListenerFilter {

	var windowTypes: JsReadonlyArray<WindowType>
}