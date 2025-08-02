@file:JsQualifier("chrome")

package chrome.extensiontypes

/**
 * Use the `chrome.tabs` API to interact with the browser's tab system. You can use this API to create, modify, and rearrange tabs in the browser.
 *
 * Permissions: The majority of the chrome.tabs API can be used without declaring any permission. However, the "tabs" permission is required in order to populate the url, title, and favIconUrl properties of Tab.
 */
@Suppress("unused")
@JsName("extensionTypes")
external object ChromeExtensionTypes