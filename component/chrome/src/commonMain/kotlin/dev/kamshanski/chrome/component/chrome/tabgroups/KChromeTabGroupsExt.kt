package dev.kamshanski.chrome.component.chrome.tabgroups

import chrome.tabgroups.Color
import chrome.tabgroups.MoveProperties
import chrome.tabgroups.QueryInfo
import chrome.tabgroups.TabGroup
import chrome.tabgroups.UpdateProperties

/**
 * Moves the group and all its tabs within its window, or to a new window.
 * @param groupId The ID of the group to move.
 * @param index The position to move the group to. Use `-1` to place the group at the end of the window.
 * @param windowId The window to move the group to. Defaults to the window the group is currently in. Note that groups can only be moved to and from windows with {@link windows.windowTypeEnum windows.windowType} type `"normal"`.
 *
 * Can return its result via Promise since Chrome 90.
 */
suspend fun KChromeTabGroups.move(
	groupId: Int,
	index: Int,
	windowId: Int? = null,
): TabGroup? =
	move(
		groupId = groupId,
		moveProperties = MoveProperties(
			index = index,
			windowId = windowId,
		)
	)

/**
 * Gets all groups that have the specified properties, or all groups if no properties are specified.
 * @param collapsed Whether the groups are collapsed.
 * @param color The color of the groups.
 * @param shared Whether the group is shared.
 * @param title Match group titles against a pattern.
 * @param windowId The ID of the parent window, or {@link windows.WINDOW_ID_CURRENT} for the current window.
 *
 * Can return its result via Promise since Chrome 90.
 */
suspend fun KChromeTabGroups.query(
	collapsed: Boolean? = null,
	color: Color? = null,
	shared: Boolean? = null,
	title: String? = null,
	windowId: Int? = null,
): List<TabGroup> =
	query(
		queryInfo = QueryInfo(
			collapsed = collapsed,
			color = color,
			shared = shared,
			title = title,
			windowId = windowId,
		)
	)

/**
 * Modifies the properties of a group. Properties that are not specified in `updateProperties` are not modified.
 * @param groupId The ID of the group to modify.
 * @param collapsed Whether the group should be collapsed.
 * @param color The color of the group.
 * @param title The title of the group.
 *
 * Can return its result via Promise since Chrome 90.
 */
suspend fun KChromeTabGroups.update(
	groupId: Int,
	collapsed: Boolean? = null,
	color: Color? = null,
	title: String? = null,
): TabGroup? =
	update(
		groupId = groupId,
		updateProperties = UpdateProperties(
			collapsed = collapsed,
			color = color,
			title = title,
		)
	)