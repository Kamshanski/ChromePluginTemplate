package chrome.events

import kotlin.js.collections.JsReadonlyArray

external interface Event<T : Function<Unit> /* (...args: any) => void */> {

	/**
	 * Registers an event listener callback to an event.
	 * @param callback Called when an event occurs. The parameters of this function depend on the type of event.
	 */
	fun addListener(callback: T)

	/**
	 * Returns currently registered rules.
	 * @param ruleIdentifiers If an array is passed, only rules with identifiers contained in this array are returned.
	 */
	fun getRules(
		/** @param rules Rules that were registered, the optional parameters are filled with values */
		callback: (rules: JsReadonlyArray<Rule>) -> Unit
	)

	fun getRules(
		ruleIdentifiers: JsReadonlyArray<String>,
		/** @param rules Rules that were registered, the optional parameters are filled with values */
		callback: (rules: JsReadonlyArray<Rule>) -> Unit
	)

	/**
	 * @param callback Listener whose registration status shall be tested.
	 * @returns True if _callback_ is registered to the event.
	 */
	fun hasListener(callback: T): Boolean

	/**
	 * Unregisters currently registered rules.
	 * @param ruleIdentifiers If an array is passed, only rules with identifiers contained in this array are unregistered.
	 */
	fun removeRules(ruleIdentifiers: JsReadonlyArray<String>? = definedExternally, callback: () -> Unit = definedExternally): Unit

	/**
	 * Registers rules to handle events.
	 * @param rules Rules to be registered. These do not replace previously registered rules.
	 * @param callback Called with registered rules.
	 */
	fun addRules(
		rules: JsReadonlyArray<Rule>,
		/** @param rules Rules that were registered, the optional parameters are filled with values */
		callback: (rules: JsReadonlyArray<Rule>) -> Unit = definedExternally
	)

	/**
	 * Deregisters an event listener callback from an event.
	 * @param callback Listener that shall be unregistered.
	 */
	fun removeListener(callback: T)

	/** @returns True if any event listeners are registered to the event. */
	fun hasListeners(): Boolean
}