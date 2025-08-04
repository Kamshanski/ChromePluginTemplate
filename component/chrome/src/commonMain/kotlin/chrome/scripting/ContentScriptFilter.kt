@file:JsQualifier("chrome.scripting")

package chrome.scripting

import kotlin.js.collections.JsReadonlyArray

/** @since Chrome 96 */
external interface ContentScriptFilter {

	/** If specified, {@link getRegisteredContentScripts} will only return scripts with an id specified in this list. */
	var ids: JsReadonlyArray<String>
}