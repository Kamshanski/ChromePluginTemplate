package chrome.events

import kotlin.js.collections.JsReadonlyArray

/** Description of a declarative rule for handling events. */
external interface Rule {

	/** Optional priority of this rule. Defaults to 100. */
	var priority: Double?

	/** List of conditions that can trigger the actions. */
	var conditions: JsReadonlyArray<Any?>

	/** Optional identifier that allows referencing this rule. */
	var id: String?

	/** List of actions that are triggered if one of the conditions is fulfilled. */
	var actions: JsReadonlyArray<Any?>

	/** Tags can be used to annotate rules and perform operations on sets of rules. */
	var tags: JsReadonlyArray<String>?
}

fun Rule(
	/** List of conditions that can trigger the actions. */
	conditions: JsReadonlyArray<Any?>,
	/** List of actions that are triggered if one of the conditions is fulfilled. */
	actions: JsReadonlyArray<Any?>,
	/** Optional priority of this rule. Defaults to 100. */
	priority: Double? = 100.0,
	/** Optional identifier that allows referencing this rule. */
	id: String? = null,
	/** Tags can be used to annotate rules and perform operations on sets of rules. */
	tags: JsReadonlyArray<String>? = null,
): Rule =
	js("{}").unsafeCast<Rule>().apply {
		this.priority = priority
		this.conditions = conditions
		this.id = id
		this.actions = actions
		this.tags = tags
	}