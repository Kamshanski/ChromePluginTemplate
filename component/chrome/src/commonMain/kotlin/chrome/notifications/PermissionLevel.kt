package chrome.notifications

import chrome.notifications.constant.PermissionLevelJsEnum

typealias PermissionLevel = String

enum class PermissionLevelEnum(private val valueProvider: PermissionLevelJsEnum.() -> PermissionLevel) {

	/** Specifies that the user has elected to show notifications from the app or extension. This is the default at install time. */
	GRANTED({ GRANTED }),

	/** Specifies that the user has elected not to show notifications from the app or extension. */
	DENIED({ DENIED });

	val value: PermissionLevel get() = valueProvider(PermissionLevelJsEnum)

	companion object {

		fun enumValueOf(value: PermissionLevel): PermissionLevelEnum = valueOf(value)
	}
}