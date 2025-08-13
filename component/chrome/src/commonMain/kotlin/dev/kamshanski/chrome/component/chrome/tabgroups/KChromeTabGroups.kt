package dev.kamshanski.chrome.component.chrome.tabgroups

import chrome.events.Event
import chrome.tabgroups.ChromeTabGroups
import chrome.tabgroups.MoveProperties
import chrome.tabgroups.QueryInfo
import chrome.tabgroups.TabGroup
import chrome.tabgroups.UpdateProperties
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await

/** @see ChromeTabGroups */
interface KChromeTabGroups {

	companion object : KChromeTabGroups {

		/** @see ChromeTabGroups.TAB_GROUP_ID_NONE */
		override val TAB_GROUP_ID_NONE: Int by ChromeTabGroups::TAB_GROUP_ID_NONE

		/** @see ChromeTabGroups.onCreated */
		override val onCreated: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onCreated

		/** @see ChromeTabGroups.onMoved */
		override val onMoved: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onMoved

		/** @see ChromeTabGroups.onRemoved */
		override val onRemoved: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onRemoved

		/** @see ChromeTabGroups.onUpdated */
		override val onUpdated: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onUpdated

		/** @see ChromeTabGroups.get */
		override suspend fun get(groupId: Int): TabGroup = ChromeTabGroups.get(groupId).await()

		/** @see ChromeTabGroups.move */
		override suspend fun move(groupId: Int, moveProperties: MoveProperties): TabGroup? = ChromeTabGroups.move(groupId, moveProperties).await()

		/** @see ChromeTabGroups.query */
		override suspend fun query(queryInfo: QueryInfo): List<TabGroup> = ChromeTabGroups.query(queryInfo).await().asList()

		/** @see ChromeTabGroups.update */
		override suspend fun update(groupId: Int, updateProperties: UpdateProperties): TabGroup? = ChromeTabGroups.update(groupId, updateProperties).await()
	}

	/** @see ChromeTabGroups.TAB_GROUP_ID_NONE */
	val TAB_GROUP_ID_NONE: Int

	/** @see ChromeTabGroups.onCreated */
	val onCreated: Event<(group: TabGroup) -> Unit>

	/** @see ChromeTabGroups.onMoved */
	val onMoved: Event<(group: TabGroup) -> Unit>

	/** @see ChromeTabGroups.onRemoved */
	val onRemoved: Event<(group: TabGroup) -> Unit>

	/** @see ChromeTabGroups.onUpdated */
	val onUpdated: Event<(group: TabGroup) -> Unit>

	/** @see ChromeTabGroups.get */
	suspend fun get(groupId: Int): TabGroup

	/** @see ChromeTabGroups.move */
	suspend fun move(groupId: Int, moveProperties: MoveProperties): TabGroup?

	/** @see ChromeTabGroups.query */
	suspend fun query(queryInfo: QueryInfo): List<TabGroup>

	/** @see ChromeTabGroups.update */
	suspend fun update(groupId: Int, updateProperties: UpdateProperties): TabGroup?
}