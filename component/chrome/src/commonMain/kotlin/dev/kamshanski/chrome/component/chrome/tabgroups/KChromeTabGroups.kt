package dev.kamshanski.chrome.component.chrome.tabgroups

import chrome.events.Event
import chrome.tabgroups.ChromeTabGroups
import chrome.tabgroups.MoveProperties
import chrome.tabgroups.QueryInfo
import chrome.tabgroups.TabGroup
import chrome.tabgroups.UpdateProperties
import dev.kamshanski.chrome.util.common.asList
import kotlinx.coroutines.await

interface KChromeTabGroups {
	companion object : KChromeTabGroups {

		override val TAB_GROUP_ID_NONE: Int by ChromeTabGroups::TAB_GROUP_ID_NONE

		override val onCreated: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onCreated

		override val onMoved: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onMoved

		override val onRemoved: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onRemoved

		override val onUpdated: Event<(group: TabGroup) -> Unit> by ChromeTabGroups::onUpdated

		override suspend fun get(groupId: Int): TabGroup = ChromeTabGroups.get(groupId).await()

		override suspend fun move(groupId: Int, moveProperties: MoveProperties): TabGroup? = ChromeTabGroups.move(groupId, moveProperties).await()

		override suspend fun query(queryInfo: QueryInfo): List<TabGroup> = ChromeTabGroups.query(queryInfo).await().asList()

		override suspend fun update(groupId: Int, updateProperties: UpdateProperties): TabGroup? = ChromeTabGroups.update(groupId, updateProperties).await()
	}

	val TAB_GROUP_ID_NONE: Int

	val onCreated: Event<(group: TabGroup) -> Unit>

	val onMoved: Event<(group: TabGroup) -> Unit>

	val onRemoved: Event<(group: TabGroup) -> Unit>

	val onUpdated: Event<(group: TabGroup) -> Unit>

	suspend fun get(groupId: Int): TabGroup

	suspend fun move(groupId: Int, moveProperties: MoveProperties): TabGroup?

	suspend fun query(queryInfo: QueryInfo): List<TabGroup>

	suspend fun update(groupId: Int, updateProperties: UpdateProperties): TabGroup?
}