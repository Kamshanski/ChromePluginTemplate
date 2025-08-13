package chrome.scripting

import dev.kamshanski.chrome.util.common.jsArrayOf
import kotlin.js.collections.JsReadonlyArray

external interface ScriptInjection<SERIALIZABLE_ARG, RESULT> {

	/**
	 * Details specifying the target into which to inject the script.
	 */
	var target: InjectionTarget

	/**
	 * The JavaScript "world" to run the script in. Defaults to ISOLATED.
	 */
	var world: ExecutionWorld?

	/**
	 * The arguments to pass to the provided function. This is only valid if the func parameter is specified. These arguments must be JSON-serializable.
	 */
	var args: JsReadonlyArray<SERIALIZABLE_ARG>?

	/**
	 * A JavaScript function to inject. This function will be serialized, and then deserialized for injection. This means that any bound parameters and execution context will be lost.
	 * Exactly one of files or func must be specified.
	 */
	var func: ((SERIALIZABLE_ARG?) -> RESULT)?

	/**
	 * Whether the injection should be triggered in the target as soon as possible.
	 * Note that this is not a guarantee that injection will occur prior to page load, as the page may have already loaded by the time the script reaches the target.
	 *
	 * @since Chrome 102
	 */
	var injectImmediately: Boolean?

	/**
	 * The path of the JS or CSS files to inject, relative to the extension's root directory. Exactly one of files or func must be specified.
	 */
	var files: JsReadonlyArray<String>?
}

/* {
    target: InjectionTarget;
    world?: `${ExecutionWorld}`;
    injectImmediately?: boolean;
} & ({
    func?: never | undefined;
    files: string[];
} | ({
    func: () => Result;
    files?: never | undefined;
} | {
    args: Args;
    func: (...args: Args) => Result;
    files?: never | undefined;
})) */

/**
 * @see chrome.scripting.ScriptInjection
 */
fun <SERIALIZABLE_ARG, RESULT> ScriptInjection(
	/**
	 * Details specifying the target into which to inject the script.
	 */
	target: InjectionTarget,
	/**
	 * A JavaScript function to inject. This function will be serialized, and then deserialized for injection. This means that any bound parameters and execution context will be lost.
	 * Exactly one of files or func must be specified.
	 */
	func: ((SERIALIZABLE_ARG?) -> RESULT),
	/**
	 * The JavaScript "world" to run the script in. Defaults to ISOLATED.
	 */
	world: ExecutionWorld? = ExecutionWorldEnum.ISOLATED.value,
	/**
	 * The arguments to pass to the provided function. This is only valid if the func parameter is specified. These arguments must be JSON-serializable.
	 */
	args: SERIALIZABLE_ARG? = null,
	/**
	 * Whether the injection should be triggered in the target as soon as possible.
	 * Note that this is not a guarantee that injection will occur prior to page load, as the page may have already loaded by the time the script reaches the target.
	 *
	 * @since Chrome 102
	 */
	injectImmediately: Boolean? = null,
): ScriptInjection<SERIALIZABLE_ARG, RESULT> =
	js("{}").unsafeCast<ScriptInjection<SERIALIZABLE_ARG, RESULT>>().apply {
		this.target = target
		this.world = world
		this.args = args?.let { jsArrayOf(it) }
		this.func = func
		this.injectImmediately = injectImmediately
		this.files = files
	}

/**
 * @see chrome.scripting.ScriptInjection
 */
fun <SERIALIZABLE_ARG, RESULT> ScriptInjection(
	/**
	 * Details specifying the target into which to inject the script.
	 */
	target: InjectionTarget,
	/**
	 * The path of the JS or CSS files to inject, relative to the extension's root directory. Exactly one of files or func must be specified.
	 */
	files: JsReadonlyArray<String>,
	/**
	 * The JavaScript "world" to run the script in. Defaults to ISOLATED.
	 */
	world: ExecutionWorld? = ExecutionWorldEnum.ISOLATED.value,
	/**
	 * Whether the injection should be triggered in the target as soon as possible.
	 * Note that this is not a guarantee that injection will occur prior to page load, as the page may have already loaded by the time the script reaches the target.
	 *
	 * @since Chrome 102
	 */
	injectImmediately: Boolean? = null,
): ScriptInjection<SERIALIZABLE_ARG, RESULT> =
	js("{}").unsafeCast<ScriptInjection<SERIALIZABLE_ARG, RESULT>>().apply {
		this.target = target
		this.world = world
		this.args = args
		this.func = func
		this.injectImmediately = injectImmediately
		this.files = files
	}