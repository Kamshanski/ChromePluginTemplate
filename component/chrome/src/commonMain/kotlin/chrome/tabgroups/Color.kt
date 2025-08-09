package chrome.tabgroups

import chrome.tabgroups.constant.ColorJsEnum

/** The group's color. */
typealias Color = String

/** @see Color */
enum class ColorEnum(private val valueProvider: ColorJsEnum.() -> Color) {

	BLUE({ BLUE }),

	CYAN({ CYAN }),

	GREEN({ GREEN }),

	GREY({ GREY }),

	ORANGE({ ORANGE }),

	PINK({ PINK }),

	PURPLE({ PURPLE }),

	RED({ RED }),

	YELLOW({ YELLOW });

	val value: Color get() = valueProvider(ColorJsEnum)

	companion object {

		fun enumValueOf(value: Color): ColorEnum = valueOf(value)
	}
}