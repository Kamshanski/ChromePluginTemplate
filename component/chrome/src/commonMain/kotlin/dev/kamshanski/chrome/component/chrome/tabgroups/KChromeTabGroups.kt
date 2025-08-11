package dev.kamshanski.chrome.component.chrome.tabgroups

import chrome.events.Event
import chrome.tabgroups.ChromeTabGroups
import chrome.tabgroups.MoveProperties
import chrome.tabgroups.QueryInfo
import chrome.tabgroups.TabGroup
import chrome.tabgroups.UpdateProperties
import kotlinx.coroutines.await
import kotlin.js.collections.JsReadonlyArray

/**
 * Use the `chrome.tabGroups` API to interact with the browser's tab grouping system. You can use this API to modify and rearrange tab groups in the browser. To group and ungroup tabs, or to query what tabs are in groups, use the `chrome.tabs` API.
 *
 * Permissions: "tabGroups"
 * @since Chrome 89, MV3
 */
object KChromeTabGroups {

	/** An ID that represents the absence of a group. */
	val TAB_GROUP_ID_NONE: Int by ChromeTabGroups::TAB_GROUP_ID_NONE

	/**
	 * Retrieves details about the specified group.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	suspend fun get(groupId: Double): TabGroup = ChromeTabGroups.get(groupId).await()

	/**
	 * Moves the group and all its tabs within its window, or to a new window.
	 * @param groupId The ID of the group to move.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	suspend fun move(groupId: Double, moveProperties: MoveProperties): TabGroup? = ChromeTabGroups.move(groupId, moveProperties).await()

	/**
	 * Gets all groups that have the specified properties, or all groups if no properties are specified.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	suspend fun query(queryInfo: QueryInfo): JsReadonlyArray<TabGroup> = ChromeTabGroups.query(queryInfo).await()

	/**
	 * Modifies the properties of a group. Properties that are not specified in `updateProperties` are not modified.
	 * @param groupId The ID of the group to modify.
	 *
	 * Can return its result via Promise since Chrome 90.
	 */
	suspend fun update(groupId: Double, updateProperties: UpdateProperties): TabGroup? = ChromeTabGroups.update(groupId, updateProperties).await()

	/** Fired when a group is created. */
	val onCreated: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onCreated

	/** Fired when a group is moved within a window. Move events are still fired for the individual tabs within the group, as well as for the group itself. This event is not fired when a group is moved between windows; instead, it will be removed from one window and created in another. */
	val onMoved: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onMoved

	/** Fired when a group is closed, either directly by the user or automatically because it contained zero tabs. */
	val onRemoved: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onRemoved

	/** Fired when a group is updated. */
	val onUpdated: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onUpdated
}