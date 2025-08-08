package dev.kamshanski.chrome.test

import chrome.bookmarks.BookmarkTreeNodeUnmodifiableEnum
import chrome.bookmarks.FolderTypeEnum
import chrome.extensiontypes.CSSOriginEnum
import chrome.extensiontypes.DocumentLifecycleEnum
import chrome.extensiontypes.ImageFormatEnum
import chrome.extensiontypes.RunAtEnum
import chrome.notifications.PermissionLevelEnum
import chrome.notifications.TemplateTypeEnum
import chrome.runtime.ContextTypeEnum
import chrome.runtime.OnInstalledReasonEnum
import chrome.runtime.OnRestartRequiredReasonEnum
import chrome.runtime.PlatformArchEnum
import chrome.runtime.PlatformNaclArchEnum
import chrome.runtime.PlatformOsEnum
import chrome.runtime.RequestUpdateCheckStatusEnum
import chrome.scripting.ExecutionWorldEnum
import chrome.scripting.StyleOriginEnum
import chrome.tabgroups.ColorEnum
import chrome.tabs.MutedInfoReasonEnum
import chrome.tabs.TabStatusEnum
import chrome.tabs.WindowTypeEnum
import chrome.tabs.ZoomSettingsModeEnum
import chrome.tabs.ZoomSettingsScopeEnum
import chrome.windows.CreateTypeEnum
import chrome.windows.WindowStateEnum
import dev.kamshanski.chrome.test.ConstantsTest.Error.MismatchedValue
import dev.kamshanski.chrome.test.ConstantsTest.Error.NotFoundValueOrEnum
import chrome.windows.WindowTypeEnum as WindowsWindowTypeEnum

@Suppress("EnumValuesSoftDeprecate")
class ConstantsTest {

	val enums: Map<Enum<*>, () -> String> =
		BookmarkTreeNodeUnmodifiableEnum.entries.associateWith { { it.value } } +
			FolderTypeEnum.entries.associateWith { { it.value } } +

			CSSOriginEnum.entries.associateWith { { it.value } } +
			DocumentLifecycleEnum.entries.associateWith { { it.value } } +
			ImageFormatEnum.entries.associateWith { { it.value } } +
			RunAtEnum.entries.associateWith { { it.value } } +

			PermissionLevelEnum.entries.associateWith { { it.value } } +
			TemplateTypeEnum.entries.associateWith { { it.value } } +

			ContextTypeEnum.entries.associateWith { { it.value } } +
			OnInstalledReasonEnum.entries.associateWith { { it.value } } +
			OnRestartRequiredReasonEnum.entries.associateWith { { it.value } } +
			PlatformArchEnum.entries.associateWith { { it.value } } +
			PlatformNaclArchEnum.entries.associateWith { { it.value } } +
			PlatformOsEnum.entries.associateWith { { it.value } } +
			RequestUpdateCheckStatusEnum.entries.associateWith { { it.value } } +

			ExecutionWorldEnum.entries.associateWith { { it.value } } +
			StyleOriginEnum.entries.associateWith { { it.value } } +

			ColorEnum.entries.associateWith { { it.value } } +

			MutedInfoReasonEnum.entries.associateWith { { it.value } } +
			TabStatusEnum.entries.associateWith { { it.value } } +
			WindowTypeEnum.entries.associateWith { { it.value } } +
			ZoomSettingsModeEnum.entries.associateWith { { it.value } } +
			ZoomSettingsScopeEnum.entries.associateWith { { it.value } } +

			CreateTypeEnum.entries.associateWith { { it.value } } +
			WindowStateEnum.entries.associateWith { { it.value } } +
			WindowsWindowTypeEnum.entries.associateWith { { it.value } } +

			emptyMap()

	fun test(): List<Error> =
		enums.mapNotNull { (entry, valueProvider) ->
			testEntry(entry, valueProvider)
		}

	private fun testEntry(entry: Enum<*>, valueProvider: () -> String?): Error? {
		val value = try {
			valueProvider() ?: return NotFoundValueOrEnum(entry, null)
		} catch (e: Throwable) {
			return NotFoundValueOrEnum(entry, e)
		}

		if (value.lowercase().replace("-", "_") != entry.name.lowercase()) {
			return MismatchedValue(entry, value)
		}

		return null
	}

	sealed interface Error {

		data class MismatchedValue(val entry: Enum<*>, val chromeValue: String) : Error
		data class NotFoundValueOrEnum(val entry: Enum<*>, val e: Throwable?) : Error
	}
}