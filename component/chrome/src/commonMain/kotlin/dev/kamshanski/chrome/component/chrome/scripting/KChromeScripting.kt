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
@Suppress("unused")
interface KChromeScripting {
	companion object : KChromeScripting {

		override suspend fun <SERIALIZABLE_ARG, RESULT> executeScript(
			injection: ScriptInjection<SERIALIZABLE_ARG, RESULT>
		): Array<InjectionResult<RESULT>> = ChromeScripting.executeScript(injection).await()

		override suspend fun insertCSS(injection: CSSInjection) = ChromeScripting.insertCSS(injection).await()

		override suspend fun removeCSS(injection: CSSInjection) = ChromeScripting.removeCSS(injection).await()

		override suspend fun registerContentScripts(scripts: List<RegisteredContentScript>) = ChromeScripting.registerContentScripts(scripts.asJsReadonlyArrayView()).await()

		override suspend fun unregisterContentScripts() = ChromeScripting.unregisterContentScripts().await()
		override suspend fun unregisterContentScripts(filter: ContentScriptFilter) = ChromeScripting.unregisterContentScripts(filter).await()

		override suspend fun getRegisteredContentScripts(): JsReadonlyArray<RegisteredContentScript> = ChromeScripting.getRegisteredContentScripts().await()
		override suspend fun getRegisteredContentScripts(filter: ContentScriptFilter): JsReadonlyArray<RegisteredContentScript> = ChromeScripting.getRegisteredContentScripts(filter).await()

		override suspend fun updateContentScripts(scripts: List<RegisteredContentScript>) = ChromeScripting.updateContentScripts(scripts.asJsReadonlyArrayView()).await()

	}

	suspend fun <SERIALIZABLE_ARG, RESULT> executeScript(
		injection: ScriptInjection<SERIALIZABLE_ARG, RESULT>
	): Array<InjectionResult<RESULT>>

	suspend fun insertCSS(injection: CSSInjection)

	suspend fun removeCSS(injection: CSSInjection)

	suspend fun registerContentScripts(scripts: List<RegisteredContentScript>)

	suspend fun unregisterContentScripts()
	suspend fun unregisterContentScripts(filter: ContentScriptFilter)

	suspend fun getRegisteredContentScripts(): JsReadonlyArray<RegisteredContentScript>
	suspend fun getRegisteredContentScripts(filter: ContentScriptFilter): JsReadonlyArray<RegisteredContentScript>

	suspend fun updateContentScripts(scripts: List<RegisteredContentScript>)
}