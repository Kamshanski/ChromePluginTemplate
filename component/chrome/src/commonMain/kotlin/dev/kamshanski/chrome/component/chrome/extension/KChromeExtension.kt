package dev.kamshanski.chrome.component.chrome.extension

import chrome.extension.ChromeExtension
import chrome.extension.FetchProperties
import chrome.extension.LastError
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await
import org.w3c.dom.Window

@Suppress("unused")
interface KChromeExtension {

	companion object : KChromeExtension {

		override var inIncognitoContext: Boolean by ChromeExtension::inIncognitoContext

		override var lastError: LastError by ChromeExtension::lastError

		override fun getBackgroundPage(): Window? = ChromeExtension.getBackgroundPage()

		override fun getURL(path: String): String = ChromeExtension.getURL(path)

		override fun setUpdateUrlData(data: String) = ChromeExtension.setUpdateUrlData(data)

		override fun getViews(fetchProperties: FetchProperties): List<Window> = ChromeExtension.getViews(fetchProperties).asList()
		override fun getViews(): List<Window> = ChromeExtension.getViews().asList()

		override suspend fun isAllowedFileSchemeAccess(): Boolean = ChromeExtension.isAllowedFileSchemeAccess().await()

		override suspend fun isAllowedIncognitoAccess(): Boolean = ChromeExtension.isAllowedIncognitoAccess().await()
	}

	var inIncognitoContext: Boolean

	var lastError: LastError

	fun getBackgroundPage(): Window?

	fun getURL(path: String): String

	fun setUpdateUrlData(data: String)

	fun getViews(fetchProperties: FetchProperties): List<Window>
	fun getViews(): List<Window>

	suspend fun isAllowedFileSchemeAccess(): Boolean

	suspend fun isAllowedIncognitoAccess(): Boolean
}