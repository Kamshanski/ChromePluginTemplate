@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface ManifestV2 : ManifestBase {

	// Required
	override var manifest_version: Int /* 2 */

	// Pick one (or none)
	var browser_action: ManifestAction?
	var page_action: ManifestAction?

	// Optional
	var background: BackgroundV2?
	var content_security_policy: String?
	var content_scripts: Array<ContentScriptV2>?
	var optional_permissions: Any? /* ManifestOptionalPermissions[] | string[] | undefined */
	var permissions: Any? /* ManifestPermissions[] | string[] | undefined */
	var web_accessible_resources: JsReadonlyArray<String>?
}