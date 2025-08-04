package dev.kamshanski.chrome.component.chrome.scripting

import chrome.scripting.CSSInjection
import chrome.scripting.ChromeScripting
import chrome.scripting.ContentScriptFilter
import chrome.scripting.InjectionResult
import chrome.scripting.RegisteredContentScript
import chrome.scripting.ScriptInjection
import kotlinx.coroutines.await
import kotlin.js.collections.JsReadonlyArray

/**
 * @see chrome.scripting.ChromeScripting
 */
object ChromeCoroutinesScripting {

	/**
	 * Injects a script into a target context. By default, the script will be run at `document_idle`, or immediately if the page has already loaded.
	 * If the `injectImmediately` property is set, the script will inject without waiting, even if the page has not finished loading.
	 * If the script evaluates to a promise, the browser will wait for the promise to settle and return the resulting value.
	 *
	 * Can return its result via Promise since Chrome 90.
	 * @param injection The details of the script which to inject.
	 */
	suspend fun <SERIALIZABLE_ARG, RESULT> executeScript(
		injection: ScriptInjection<SERIALIZABLE_ARG, RESULT>
	): Array<InjectionResult<RESULT>> = ChromeScripting.executeScript(injection).await()

	/**
	 * Inserts a CSS stylesheet into a target context. If multiple frames are specified, unsuccessful injections are ignored.
	 *
	 * Can return its result via Promise since Chrome 90.
	 * @param injection The details of the styles to insert.
	 */
	suspend fun insertCSS(injection: CSSInjection) = ChromeScripting.insertCSS(injection).await()

	/**
	 * Removes a CSS stylesheet that was previously inserted by this extension from a target context.
	 * @param injection The details of the styles to remove. Note that the `css`, `files`, and `origin` properties must exactly match the stylesheet inserted through {@link insertCSS}.
	 * Attempting to remove a non-existent stylesheet is a no-op.
	 * @since Chrome 90
	 */
	suspend fun removeCSS(injection: CSSInjection) = ChromeScripting.removeCSS(injection).await()

	/**
	 * Registers one or more content scripts for this extension
	 * @param scripts Contains a list of scripts to be registered. If there are errors during script parsing/file validation, or if the IDs specified already exist, then no scripts are registered.
	 * @since Chrome 96
	 */
	suspend fun registerContentScripts(scripts: JsReadonlyArray<RegisteredContentScript>) = ChromeScripting.registerContentScripts(scripts).await()

	/**
	 * Unregisters content scripts for this extension.
	 * @param filter If specified, only unregisters dynamic content scripts which match the filter. Otherwise, all of the extension's dynamic content scripts are unregistered.
	 * @since Chrome 96
	 */
	suspend fun unregisterContentScripts() = ChromeScripting.unregisterContentScripts().await()
	suspend fun unregisterContentScripts(filter: ContentScriptFilter) = ChromeScripting.unregisterContentScripts(filter).await()

	/**
	 * Returns all dynamically registered content scripts for this extension that match the given filter.
	 * @param filter An object to filter the extension's dynamically registered scripts.
	 * @since Chrome 96
	 */
	suspend fun getRegisteredContentScripts(): JsReadonlyArray<RegisteredContentScript> = ChromeScripting.getRegisteredContentScripts().await()
	suspend fun getRegisteredContentScripts(filter: ContentScriptFilter): JsReadonlyArray<RegisteredContentScript> = ChromeScripting.getRegisteredContentScripts(filter).await()

	/**
	 * Updates one or more content scripts for this extension.
	 * @param scripts Contains a list of scripts to be updated. A property is only updated for the existing script if it is specified in this object.
	 * If there are errors during script parsing/file validation, or if the IDs specified do not correspond to a fully registered script, then no scripts are updated.
	 * @since Chrome 96
	 */
	suspend fun updateContentScripts(scripts: JsReadonlyArray<RegisteredContentScript>) = ChromeScripting.updateContentScripts(scripts).await()
}