package chrome.runtime

/** @since Chrome 114 */
typealias ContextType = String

enum class ContextTypeEnum {

	/** Specifies the context type as a tab */
	tab,

	/** Specifies the context type as an extension popup window */
	popup,

	/** Specifies the context type as a service worker. */
	background,

	/** Specifies the context type as an offscreen document. */
	offscreen_document,

	/** Specifies the context type as a side panel. */
	side_panel,

	/** Specifies the context type as developer tools. */
	developer_tools,
	;

	val value: ContextType = name

	companion object {

		fun enumValueOf(value: ContextType): ContextTypeEnum = valueOf(value)
	}
}