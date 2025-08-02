@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface SearchProvider {

	var name: String?
	var keyword: String?
	var favicon_url: String?
	var search_url: String
	var encoding: String?
	var suggest_url: String?
	var instant_url: String?
	var image_url: String?
	var search_url_post_params: String?
	var suggest_url_post_params: String?
	var instant_url_post_params: String?
	var image_url_post_params: String?
	var alternate_urls: JsReadonlyArray<String>?
	var prepopulated_id: Int?
	var is_default: Boolean?
}