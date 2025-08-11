package chrome.tabs

external interface OnUpdatedInfo {

	/** The tab's new audible state. */
	var audible: Boolean?

	/**
	 * The tab's new auto-discardable state.
	 * @since Chrome 54
	 */
	var autoDiscardable: Boolean?

	/**
	 * The tab's new discarded state.
	 * @since Chrome 54
	 */
	var discarded: Boolean?

	/** The tab's new favicon URL. */
	var favIconUrl: String?

	/**
	 * The tab's new frozen state.
	 * @since Chrome 132
	 */
	var frozen: Boolean?

	/**
	 * The tab's new group.
	 * @since Chrome 88
	 */
	var groupId: Int?

	/**
	 * The tab's new muted state and the reason for the change.
	 * @since Chrome 46
	 */
	var mutedInfo: MutedInfo?

	/** The tab's new pinned state. */
	var pinned: Boolean?

	/** The tab's loading status. */
	var status: TabStatus?

	/**
	 * The tab's new title.
	 * @since Chrome 48
	 */
	var title: String?

	/** The tab's URL if it has changed. */
	var url: String?
}