@file:JsQualifier("chrome")

package chrome.tabgroups

import chrome.events.Event
import kotlin.js.Promise
import kotlin.js.collections.JsReadonlyArray

/**
 * Use the `chrome.tabGroups` API to interact with the browser's tab grouping system. You can use this API to modify and rearrange tab groups in the browser. To group and ungroup tabs, or to query what tabs are in groups, use the `chrome.tabs` API.
 *
 * Permissions: "tabGroups"
 * @since Chrome 89, MV3
 */
@JsName("tabGroups")
external object ChromeTabGroups {

	/** An ID that represents the absence of a group. */
	val TAB_GROUP_ID_NONE: Int /* -1 */

	/**
	 * Retrieves details about the specified group.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	fun get(groupId: Double): Promise<TabGroup>
	fun get(groupId: Double, callback: (group: TabGroup) -> Unit)

	/**
	 * Moves the group and all its tabs within its window, or to a new window.
	 * @param groupId The ID of the group to move.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	fun move(groupId: Double, moveProperties: MoveProperties): Promise<TabGroup?>
	fun move(groupId: Double, moveProperties: MoveProperties, callback: (group: TabGroup? /* use undefined for default */) -> Unit)

	/**
	 * Gets all groups that have the specified properties, or all groups if no properties are specified.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	fun query(queryInfo: QueryInfo): Promise<JsReadonlyArray<TabGroup>>
	fun query(queryInfo: QueryInfo, callback: (result: JsReadonlyArray<TabGroup>) -> Unit)

	/**
	 * Modifies the properties of a group. Properties that are not specified in `updateProperties` are not modified.
	 * @param groupId The ID of the group to modify.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	fun update(groupId: Double, updateProperties: UpdateProperties): Promise<TabGroup?>
	fun update(groupId: Double, updateProperties: UpdateProperties, callback: (group: TabGroup? /* use undefined for default */) -> Unit)

	/** Fired when a group is created. */
	val onCreated: Event<(group: TabGroup) -> Unit>

	/** Fired when a group is moved within a window. Move events are still fired for the individual tabs within the group, as well as for the group itself. This event is not fired when a group is moved between windows; instead, it will be removed from one window and created in another. */
	val onMoved: Event<(group: TabGroup) -> Unit>

	/** Fired when a group is closed, either directly by the user or automatically because it contained zero tabs. */
	val onRemoved: Event<(group: TabGroup) -> Unit>

	/** Fired when a group is updated. */
	val onUpdated: Event<(group: TabGroup) -> Unit>
}