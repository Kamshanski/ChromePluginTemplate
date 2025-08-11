package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface Oauth2 {

	var client_id: String
	var scopes: JsReadonlyArray<String>?
}