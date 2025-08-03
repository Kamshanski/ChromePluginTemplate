package dev.kamshanski.chrome.domain

import chrome.bookmarks.BookmarkTreeNode
import chrome.bookmarks.UpdateChanges
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalJsExport::class)
class ReplaceVostorgUrlEverywhereUseCaseTest {

	@Test
	fun test() = runTest {
		val getTreeMock: suspend () -> List<BookmarkTreeNode> = {
			listOf(
				BookmarkTreeNode {
					id = "Root"
					children = listOf(
						// Changed
						BookmarkTreeNode {
							id = "anivost1"
							url = "https://v7.vost.pw"
						},
						BookmarkTreeNode {
							id = "anivost2"
							url = "https://v2.vost.pw/"
						},
						BookmarkTreeNode {
							id = "anivost3"
							url = "https://v11.vost.pw/tip/ona/123-hello.html"
						},
						BookmarkTreeNode {
							id = "folder"
							children = listOf(
								BookmarkTreeNode {
									id = "anivost4"
									url = "https://v19.vost.pw/tip/ona/hoho.html"
								},
							).asJsReadonlyArrayView()
						},

						// Unchanged
						BookmarkTreeNode {
							id = "anivost5"
							url = "https://v9.vost.pw/tip/ona/09090-fake.html"
						},
						BookmarkTreeNode {
							id = "fakeAnivost2"
							url = "https://v19.post.pw/tip/ona/233-bye.html"
						},
					).asJsReadonlyArrayView()
				},
			)
		}
		val updateMock: suspend (String, UpdateChanges) -> BookmarkTreeNode = { nodeId, ch ->
			when (nodeId) {
				"anivost1" -> BookmarkTreeNode {
					id = "anivost1"
					url = ch.url
				}

				"anivost2" -> BookmarkTreeNode {
					id = "anivost2"
					url = ch.url
				}

				"anivost3" -> BookmarkTreeNode {
					id = "anivost3"
					url = ch.url
				}

				"anivost4" -> BookmarkTreeNode {
					id = "anivost4"
					url = ch.url
				}

				else       -> error("Unexpected node id: $nodeId")
			}
		}

		val updatedBookmarks = replaceVostorgUrlEverywhereUseCase(
			vostorgReplacement = "https://v9.vost.pw",
			vostorgPattern = "https:\\/\\/v\\d+.vost.pw",
			getTree = getTreeMock,
			update = updateMock,
		)

		assertEquals(
			listOf(
				UpdatedBookmark("anivost1", "https://v7.vost.pw", "https://v9.vost.pw"),
				UpdatedBookmark("anivost2", "https://v2.vost.pw/", "https://v9.vost.pw/"),
				UpdatedBookmark("anivost3", "https://v11.vost.pw/tip/ona/123-hello.html", "https://v9.vost.pw/tip/ona/123-hello.html"),
				UpdatedBookmark("anivost4", "https://v19.vost.pw/tip/ona/hoho.html", "https://v9.vost.pw/tip/ona/hoho.html"),
			),
			updatedBookmarks,
		)
	}
}

private fun BookmarkTreeNode(init: BookmarkTreeNode.() -> Unit): BookmarkTreeNode =
	js("{}").unsafeCast<BookmarkTreeNode>().apply(init)
