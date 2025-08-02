@file:JsQualifier("chrome.runtime")

package chrome.runtime

import chrome.declarativecontent.PageStateMatcherProperties
import kotlin.js.collections.JsReadonlyArray

external interface EventRule {

	var event: String?
	var actions: Array<Action>?
	var conditions: JsReadonlyArray<PageStateMatcherProperties>?
}