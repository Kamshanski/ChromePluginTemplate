package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface ManifestV3 : ManifestBase {

	// Required
	override var manifest_version: Int /* 3 */

	// Optional
	var action: ManifestAction?
	var background: (BackgoundV3)?
	var content_scripts: Array<ContentScriptV3>?
	var content_security_policy: (ManifestV3ContentSecurityPolicy)?
	var host_permissions: JsReadonlyArray<String>?
	var optional_permissions: JsReadonlyArray<ManifestPermissions>?
	var optional_host_permissions: JsReadonlyArray<String>?
	var permissions: JsReadonlyArray<ManifestPermissions>?
	var web_accessible_resources: Array<WebAccessibleResource>?
}

