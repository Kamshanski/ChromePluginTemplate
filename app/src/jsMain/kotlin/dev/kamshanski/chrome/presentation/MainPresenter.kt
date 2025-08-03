package dev.kamshanski.chrome.presentation

import dev.kamshanski.chrome.component.log.i
import dev.kamshanski.chrome.domain.replaceVostorgUrlEverywhereUseCase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch

class MainPresenter {

	private val scope = MainScope()

	val state = MutableStateFlow<MainState>(
		MainState(
			vostorgReplacement = "https://v9.vost.pw",
			vostorgPattern = "https:\\/\\/v\\d+.vost.pw",
			vostorgState = VostorgState.None,
		)
	)

	fun setVostorgReplacement(url: String) {
		if (state.value.vostorgState is VostorgState.Replacing) return
		state.update { it.copy(vostorgReplacement = url) }
	}

	fun setVostorgPattern(pattern: String) {
		if (state.value.vostorgState is VostorgState.Replacing) return
		state.update { it.copy(vostorgPattern = pattern) }
	}

	fun replaceEverywhere() {
		if (state.value.vostorgState is VostorgState.Replacing || state.value.vostorgReplacement.isBlank()) return

		val curState = state.updateAndGet { it.copy(vostorgState = VostorgState.Replacing) }

		scope.launch {
			try {
				replaceVostorgUrlEverywhereUseCase(
					vostorgReplacement = curState.vostorgReplacement,
					vostorgPattern = curState.vostorgPattern,
				)
					.i { "Successfully replaced $it" }
				state.value = curState.copy(vostorgState = VostorgState.None)
			} catch (e: Throwable) {
				e.printStackTrace()
				state.value = curState.copy(vostorgState = VostorgState.Failed(e.message?.takeIf { it.isNotBlank() }))
			}
		}
	}
}