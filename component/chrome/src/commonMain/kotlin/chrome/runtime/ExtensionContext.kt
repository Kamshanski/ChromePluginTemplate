package chrome.runtime

/**
 * A context hosting extension content.
 * @since Chrome 114
 */
external interface ExtensionContext {

	/** A unique identifier for this context */
	var contextId: String

	/** The type of context this corresponds to. */
	var contextType: ContextType

	/** A UUID for the document associated with this context, or undefined if this context is hosted not in a document.*/
	var documentId: String?

	/** The origin of the document associated with this context, or undefined if the context is not hosted in a document. */
	var documentOrigin: String?

	/** The URL of the document associated with this context, or undefined if the context is not hosted in a document. */
	var documentUrl: String?

	/** The ID of the frame for this context, or `-1` if this context is not hosted in a frame. */
	var frameId: Int

	/** Whether the context is associated with an incognito profile. */
	var incognito: Boolean

	/** The ID of the tab for this context, or `-1` if this context is not hosted in a tab. */
	var tabId: Int

	/** The ID of the window for this context, or `-1` if this context is not hosted in a window. */
	var windowId: Int
}