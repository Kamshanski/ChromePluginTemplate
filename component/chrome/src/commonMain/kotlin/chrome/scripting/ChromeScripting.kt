@file:JsQualifier("chrome")

package chrome.scripting

import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

/**
 * Use the `chrome.scripting` API to execute script in different contexts.
 *
 * Permissions: "scripting"
 * @since Chrome 88, MV3
 */
@Suppress("unused")
@JsName("scripting")
external object ChromeScripting {

	/**
	 * Injects a script into a target context. By default, the script will be run at `document_idle`, or immediately if the page has already loaded.
	 * If the `injectImmediately` property is set, the script will inject without waiting, even if the page has not finished loading.
	 * If the script evaluates to a promise, the browser will wait for the promise to settle and return the resulting value.
	 *
	 * Can return its result via Promise since Chrome 90.
	 * @param injection The details of the script which to inject.
	 */
	fun <SERIALIZABLE_ARG, RESULT> executeScript(
		injection: ScriptInjection<SERIALIZABLE_ARG, RESULT>
	): Promise<Array<InjectionResult<RESULT>>>

	fun <SERIALIZABLE_ARG, Result> executeScript(
		injection: ScriptInjection<SERIALIZABLE_ARG, Result>,
		callback: (results: Array<InjectionResult<Result>>) -> Unit
	)

	/**
	 * Inserts a CSS stylesheet into a target context. If multiple frames are specified, unsuccessful injections are ignored.
	 *
	 * Can return its result via Promise since Chrome 90.
	 * @param injection The details of the styles to insert.
	 */
	fun insertCSS(injection: CSSInjection): Promise<Unit>
	fun insertCSS(injection: CSSInjection, callback: () -> Unit)

	/**
	 * Removes a CSS stylesheet that was previously inserted by this extension from a target context.
	 * @param injection The details of the styles to remove. Note that the `css`, `files`, and `origin` properties must exactly match the stylesheet inserted through {@link insertCSS}.
	 * Attempting to remove a non-existent stylesheet is a no-op.
	 * @since Chrome 90
	 */
	fun removeCSS(injection: CSSInjection): Promise<Unit>
	fun removeCSS(injection: CSSInjection, callback: () -> Unit)

	/**
	 * Registers one or more content scripts for this extension
	 * @param scripts Contains a list of scripts to be registered. If there are errors during script parsing/file validation, or if the IDs specified already exist, then no scripts are registered.
	 * @since Chrome 96
	 */
	fun registerContentScripts(scripts: JsReadonlyArray<RegisteredContentScript>): Promise<Unit>
	fun registerContentScripts(scripts: JsReadonlyArray<RegisteredContentScript>, callback: () -> Unit)

	/**
	 * Unregisters content scripts for this extension.
	 * @param filter If specified, only unregisters dynamic content scripts which match the filter. Otherwise, all of the extension's dynamic content scripts are unregistered.
	 * @since Chrome 96
	 */
	fun unregisterContentScripts(filter: ContentScriptFilter = definedExternally): Promise<Unit>
	fun unregisterContentScripts(callback: () -> Unit)
	fun unregisterContentScripts(filter: ContentScriptFilter?, callback: () -> Unit)

	/**
	 * Returns all dynamically registered content scripts for this extension that match the given filter.
	 * @param filter An object to filter the extension's dynamically registered scripts.
	 * @since Chrome 96
	 */
	fun getRegisteredContentScripts(filter: ContentScriptFilter = definedExternally): Promise<JsReadonlyArray<RegisteredContentScript>>
	fun getRegisteredContentScripts(callback: (scripts: JsReadonlyArray<RegisteredContentScript>) -> Unit)
	fun getRegisteredContentScripts(filter: ContentScriptFilter?, callback: (scripts: JsReadonlyArray<RegisteredContentScript>) -> Unit)

	/**
	 * Updates one or more content scripts for this extension.
	 * @param scripts Contains a list of scripts to be updated. A property is only updated for the existing script if it is specified in this object.
	 * If there are errors during script parsing/file validation, or if the IDs specified do not correspond to a fully registered script, then no scripts are updated.
	 * @since Chrome 96
	 */
	fun updateContentScripts(scripts: JsReadonlyArray<RegisteredContentScript>): Promise<Unit>
	fun updateContentScripts(scripts: JsReadonlyArray<RegisteredContentScript>, callback: () -> Unit)
}