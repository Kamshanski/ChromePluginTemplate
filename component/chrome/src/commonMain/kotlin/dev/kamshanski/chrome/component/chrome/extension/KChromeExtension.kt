package dev.kamshanski.chrome.component.chrome.extension

import chrome.extension.ChromeExtension
import chrome.extension.FetchProperties
import chrome.extension.LastError
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await
import org.w3c.dom.Window

/** @see ChromeExtension */
interface KChromeExtension {

	companion object : KChromeExtension {

		/** @see ChromeExtension.inIncognitoContext */
		override var inIncognitoContext: Boolean by ChromeExtension::inIncognitoContext

		/** @see ChromeExtension.lastError */
		override var lastError: LastError by ChromeExtension::lastError

		/** @see ChromeExtension.getBackgroundPage() */
		override fun getBackgroundPage(): Window? = ChromeExtension.getBackgroundPage()

		/** @see ChromeExtension.getURL(path: String) */
		override fun getURL(path: String): String = ChromeExtension.getURL(path)

		/** @see ChromeExtension.setUpdateUrlData(data: String) */
		override fun setUpdateUrlData(data: String) = ChromeExtension.setUpdateUrlData(data)

		/** @see ChromeExtension.getViews(fetchProperties: FetchProperties) */
		override fun getViews(fetchProperties: FetchProperties): List<Window> = ChromeExtension.getViews(fetchProperties).asList()

		/** @see ChromeExtension.getViews() */
		override fun getViews(): List<Window> = ChromeExtension.getViews().asList()

		/** @see ChromeExtension.isAllowedFileSchemeAccess() */
		override suspend fun isAllowedFileSchemeAccess(): Boolean = ChromeExtension.isAllowedFileSchemeAccess().await()

		/** @see ChromeExtension.isAllowedIncognitoAccess() */
		override suspend fun isAllowedIncognitoAccess(): Boolean = ChromeExtension.isAllowedIncognitoAccess().await()
	}

	/** @see ChromeExtension.inIncognitoContext */
	var inIncognitoContext: Boolean

	/** @see ChromeExtension.lastError */
	var lastError: LastError

	/** @see ChromeExtension.getBackgroundPage() */
	fun getBackgroundPage(): Window?

	/** @see ChromeExtension.getURL(path: String) */
	fun getURL(path: String): String

	/** @see ChromeExtension.setUpdateUrlData(data: String) */
	fun setUpdateUrlData(data: String)

	/** @see ChromeExtension.getViews(fetchProperties: FetchProperties) */
	fun getViews(fetchProperties: FetchProperties): List<Window>

	/** @see ChromeExtension.getViews() */
	fun getViews(): List<Window>

	/** @see ChromeExtension.isAllowedFileSchemeAccess() */
	suspend fun isAllowedFileSchemeAccess(): Boolean

	/** @see ChromeExtension.isAllowedIncognitoAccess() */
	suspend fun isAllowedIncognitoAccess(): Boolean
}