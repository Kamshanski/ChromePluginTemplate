package chrome.runtime

import chrome.scripting.ExecutionWorld
import kotlin.js.collections.JsReadonlyArray

external interface ContentScriptV3 {

	var matches: JsReadonlyArray<String>?
	var exclude_matches: JsReadonlyArray<String>?
	var css: JsReadonlyArray<String>?
	var js: JsReadonlyArray<String>?
	var run_at: String?
	var all_frames: Boolean?
	var match_about_blank: Boolean?
	var include_globs: JsReadonlyArray<String>?
	var exclude_globs: JsReadonlyArray<String>?
	var world: ExecutionWorld?
}