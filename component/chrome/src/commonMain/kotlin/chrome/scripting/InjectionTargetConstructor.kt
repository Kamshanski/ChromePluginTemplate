package chrome.scripting

/**
 * allFrames = true
 * @see chrome.scripting.InjectionTarget
 */
fun InjectionTarget(
	/** The ID of the tab into which to inject. */
	tabId: Int,
): InjectionTarget =
	js("{}").unsafeCast<InjectionTarget>().apply {
		this.tabId = tabId
		this.allFrames = true
	}

/**
 * Inject into documents
 * @see chrome.scripting.InjectionTarget
 */
fun InjectionTarget(
	/** The ID of the tab into which to inject. */
	tabId: Int,
	/**
	 * The IDs of specific documentIds to inject into. This must not be set if frameIds is set.
	 *
	 * @since Chrome 106
	 */
	documentIds: List<String>,
): InjectionTarget =
	js("{}").unsafeCast<InjectionTarget>().apply {
		this.tabId = tabId
		this.documentIds = documentIds.asJsReadonlyArrayView()
	}

/**
 * Inject into frames
 * @see chrome.scripting.InjectionTarget
 */
fun InjectionTarget(
	/** The ID of the tab into which to inject. */
	tabId: Int,
	/** The IDs of specific frames to inject into. */
	frameIds: List<Int>,
): InjectionTarget =
	js("{}").unsafeCast<InjectionTarget>().apply {
		this.tabId = tabId
		this.frameIds = frameIds.asJsReadonlyArrayView()
	}