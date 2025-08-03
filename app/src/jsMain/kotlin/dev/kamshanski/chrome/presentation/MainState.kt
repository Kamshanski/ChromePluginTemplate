package dev.kamshanski.chrome.presentation

data class MainState(
	val vostorgReplacement: String,
	val vostorgState: VostorgState,
	val vostorgPattern: String,
)

sealed interface VostorgState {

	data object None : VostorgState
	data object Replacing : VostorgState
	data class Failed(val message: String?) : VostorgState
}