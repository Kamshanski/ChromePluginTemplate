@file:JsQualifier("chrome.scripting")

package chrome.scripting.constant

import chrome.scripting.ExecutionWorld

@JsName("ExecutionWorld")
internal external object ExecutionWorldJsEnum {

	val ISOLATED: ExecutionWorld
	val MAIN: ExecutionWorld
}