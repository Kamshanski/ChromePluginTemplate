package chrome.extensiontypes

/**
 * The soonest that the JavaScript or CSS will be injected into the tab.
 *
 * "document_start" : Script is injected after any files from css, but before any other DOM is constructed or any other script is run.
 *
 * "document_end" : Script is injected immediately after the DOM is complete, but before subresources like images and frames have loaded.
 *
 * "document_idle" : The browser chooses a time to inject the script between "document_end" and immediately after the `window.onload` event fires. The exact moment of injection depends on how complex the document is and how long it is taking to load, and is optimized for page load speed. Content scripts running at "document_idle" don't need to listen for the `window.onload` event; they are guaranteed to run after the DOM completes. If a script definitely needs to run after `window.onload`, the extension can check if `onload` has already fired by using the `document.readyState` property.
 * @since Chrome 44
 */
typealias RunAt = String

enum class RunAtEnum {

	document_start,
	document_end,
	document_idle,
	;

	val value: RunAt = name

	companion object {

		fun enumValueOf(value: RunAt): RunAtEnum = valueOf(value)
	}
}