@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface Spellcheck {

	var dictionary_language: String?
	var dictionary_locale: String?
	var dictionary_format: String?
	var dictionary_path: String?
}