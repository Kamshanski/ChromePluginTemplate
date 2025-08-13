package dev.kamshanski.chrome.component.chrome.scripting

import chrome.scripting.CSSInjection
import chrome.scripting.ChromeScripting
import chrome.scripting.ContentScriptFilter
import chrome.scripting.InjectionResult
import chrome.scripting.RegisteredContentScript
import chrome.scripting.ScriptInjection
import kotlinx.coroutines.await
import kotlin.js.collections.JsReadonlyArray

/** @see ChromeScripting */
interface KChromeScripting {

	companion object : KChromeScripting {

		/** @see ChromeScripting.executeScript */
		override suspend fun <SERIALIZABLE_ARG, RESULT> executeScript(
			injection: ScriptInjection<SERIALIZABLE_ARG, RESULT>
		): Array<InjectionResult<RESULT>> = ChromeScripting.executeScript(injection).await()

		/** @see ChromeScripting.insertCSS */
		override suspend fun insertCSS(injection: CSSInjection) = ChromeScripting.insertCSS(injection).await()

		/** @see ChromeScripting.removeCSS */
		override suspend fun removeCSS(injection: CSSInjection) = ChromeScripting.removeCSS(injection).await()

		/** @see ChromeScripting.registerContentScripts */
		override suspend fun registerContentScripts(scripts: List<RegisteredContentScript>) = ChromeScripting.registerContentScripts(scripts.asJsReadonlyArrayView()).await()

		/** @see ChromeScripting.unregisterContentScripts */
		override suspend fun unregisterContentScripts() = ChromeScripting.unregisterContentScripts().await()

		/** @see ChromeScripting.unregisterContentScripts */
		override suspend fun unregisterContentScripts(filter: ContentScriptFilter) = ChromeScripting.unregisterContentScripts(filter).await()

		/** @see ChromeScripting.getRegisteredContentScripts */
		override suspend fun getRegisteredContentScripts(): JsReadonlyArray<RegisteredContentScript> = ChromeScripting.getRegisteredContentScripts().await()

		/** @see ChromeScripting.getRegisteredContentScripts */
		override suspend fun getRegisteredContentScripts(filter: ContentScriptFilter): JsReadonlyArray<RegisteredContentScript> = ChromeScripting.getRegisteredContentScripts(filter).await()

		/** @see ChromeScripting.updateContentScripts */
		override suspend fun updateContentScripts(scripts: List<RegisteredContentScript>) = ChromeScripting.updateContentScripts(scripts.asJsReadonlyArrayView()).await()
	}

	/** @see ChromeScripting.executeScript */
	suspend fun <SERIALIZABLE_ARG, RESULT> executeScript(
		injection: ScriptInjection<SERIALIZABLE_ARG, RESULT>
	): Array<InjectionResult<RESULT>>

	/** @see ChromeScripting.insertCSS */
	suspend fun insertCSS(injection: CSSInjection)

	/** @see ChromeScripting.removeCSS */
	suspend fun removeCSS(injection: CSSInjection)

	/** @see ChromeScripting.registerContentScripts */
	suspend fun registerContentScripts(scripts: List<RegisteredContentScript>)

	/** @see ChromeScripting.unregisterContentScripts */
	suspend fun unregisterContentScripts()

	/** @see ChromeScripting.unregisterContentScripts */
	suspend fun unregisterContentScripts(filter: ContentScriptFilter)

	/** @see ChromeScripting.getRegisteredContentScripts */
	suspend fun getRegisteredContentScripts(): JsReadonlyArray<RegisteredContentScript>

	/** @see ChromeScripting.getRegisteredContentScripts */
	suspend fun getRegisteredContentScripts(filter: ContentScriptFilter): JsReadonlyArray<RegisteredContentScript>

	/** @see ChromeScripting.updateContentScripts */
	suspend fun updateContentScripts(scripts: List<RegisteredContentScript>)
}