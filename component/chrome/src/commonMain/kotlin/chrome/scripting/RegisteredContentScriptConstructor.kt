package chrome.scripting

import chrome.extensiontypes.RunAt
import chrome.extensiontypes.RunAtEnum
import kotlin.js.collections.JsReadonlyArray

/**
 * @see chrome.scripting.RegisteredContentScript
 */
fun RegisteredContentScript(
	/**
	 * The id of the content script, specified in the API call. Must not start with a '_' as it's reserved as a prefix for generated script IDs.
	 */
	id: String,
	/**
	 * The list of JavaScript files to be injected into matching pages. These are injected in the order they appear in this array.
	 */
	js: JsReadonlyArray<String>? = null,
	/**
	 * The list of CSS files to be injected into matching pages. These are injected in the order they appear in this array, before any DOM is constructed or displayed for the page.
	 */
	css: JsReadonlyArray<String>? = null,
	/**
	 * If specified true, it will inject into all frames, even if the frame is not the top-most frame in the tab.
	 * Each frame is checked independently for URL requirements; it will not inject into child frames if the URL requirements are not met. Defaults to false, meaning that only the top frame is matched.
	 */
	allFrames: Boolean = false,
	/**
	 * Excludes pages that this content script would otherwise be injected into. See Match Patterns for more details on the syntax of these strings.
	 */
	excludeMatches: JsReadonlyArray<String>? = null,
	/**
	 * Indicates whether the script can be injected into frames where the URL contains an unsupported scheme; specifically: about:, data:, blob:, or filesystem:.
	 * In these cases, the URL's origin is checked to determine if the script should be injected.
	 * If the origin is null (as is the case for data: URLs) then the used origin is either the frame that created the current frame or the frame that initiated the navigation to this frame.
	 * Note that this may not be the parent frame.
	 *
	 * @since Chrome 119
	 */
	matchOriginAsFallback: Boolean? = null,
	/**
	 * Specifies which pages this content script will be injected into. See Match Patterns for more details on the syntax of these strings. Must be specified for registerContentScripts.
	 */
	matches: JsReadonlyArray<String>? = null,
	/**
	 * Specifies if this content script will persist into future sessions. The default is true.
	 */
	persistAcrossSessions: Boolean = true,
	/**
	 * Specifies when JavaScript files are injected into the web page. The preferred and default value is document_idle.
	 */
	runAt: RunAt = RunAtEnum.document_idle.value,
	/**
	 * The JavaScript "world" to run the script in. Defaults to ISOLATED.
	 */
	world: ExecutionWorld = ExecutionWorldEnum.ISOLATED.value,
): RegisteredContentScript =
	js("{}").unsafeCast<RegisteredContentScript>().apply {
		this.id = id
		this.js = js
		this.css = css
		this.allFrames = allFrames
		this.excludeMatches = excludeMatches
		this.matchOriginAsFallback = matchOriginAsFallback
		this.matches = matches
		this.persistAcrossSessions = persistAcrossSessions
		this.runAt = runAt
		this.world = world
	}