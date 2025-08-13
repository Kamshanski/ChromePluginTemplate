package chrome.windows

import chrome.events.Event

external interface WindowsEvent<T : Function<Unit> /* (...args: any) => void */> : Event<T> {

	fun addListener(callback: T, filter: WindowsEventAddListenerFilter)
}
