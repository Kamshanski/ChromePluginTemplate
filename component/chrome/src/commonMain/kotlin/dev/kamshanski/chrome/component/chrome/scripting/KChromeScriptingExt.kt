package dev.kamshanski.chrome.component.chrome.scripting

import chrome.scripting.CSSInjection
import chrome.scripting.ExecutionWorld
import chrome.scripting.ExecutionWorldEnum
import chrome.scripting.InjectionResult
import chrome.scripting.InjectionTarget
import chrome.scripting.ScriptInjection
import chrome.scripting.StyleOrigin
import kotlin.js.collections.JsReadonlyArray

/**
 * @see chrome.scripting.ChromeScripting.executeScript
 * @see ScriptInjection
 */
suspend fun <SERIALIZABLE_ARG, RESULT> KChromeScripting.executeScript(
	target: InjectionTarget,
	files: List<String>,
	world: ExecutionWorld? = ExecutionWorldEnum.ISOLATED.value,
	injectImmediately: Boolean? = null,
): Array<InjectionResult<RESULT>> =
	executeScript(
		ScriptInjection<SERIALIZABLE_ARG, RESULT>(
			target = target,
			world = world,
			files = files.asJsReadonlyArrayView(),
			injectImmediately = injectImmediately,
		)
	)

/**
 * @see chrome.scripting.ChromeScripting.executeScript
 * @see ScriptInjection
 */
suspend fun <SERIALIZABLE_ARG, RESULT> KChromeScripting.executeScript(
	target: InjectionTarget,
	func: ((SERIALIZABLE_ARG?) -> RESULT),
	world: ExecutionWorld? = ExecutionWorldEnum.ISOLATED.value,
	args: SERIALIZABLE_ARG? = null,
	injectImmediately: Boolean? = null,
): Array<InjectionResult<RESULT>> =
	executeScript(
		ScriptInjection<SERIALIZABLE_ARG, RESULT>(
			target = target,
			world = world,
			func = func,
			args = args,
			injectImmediately = injectImmediately,
		)
	)

/**
 * @see chrome.scripting.ChromeScripting.insertCSS
 * @see CSSInjection
 */
suspend fun KChromeScripting.insertCSS(
	target: InjectionTarget,
	css: String,
	origin: StyleOrigin? = null,
): Unit =
	insertCSS(
		CSSInjection(
			target = target,
			css = css,
			origin = origin
		)
	)

/**
 * @see chrome.scripting.ChromeScripting.insertCSS
 * @see CSSInjection
 */
suspend fun KChromeScripting.insertCSS(
	origin: StyleOrigin? = null,
	target: InjectionTarget,
	files: JsReadonlyArray<String>? = null,
): Unit =
	insertCSS(
		CSSInjection(
			target = target,
			files = files,
			origin = origin
		)
	)

/**
 * @see chrome.scripting.ChromeScripting.removeCSS
 * @see CSSInjection
 */
suspend fun KChromeScripting.removeCSS(
	target: InjectionTarget,
	css: String,
	origin: StyleOrigin? = null,
): Unit =
	removeCSS(
		CSSInjection(
			target = target,
			css = css,
			origin = origin
		)
	)

/**
 * @see chrome.scripting.ChromeScripting.removeCSS
 * @see CSSInjection
 */
suspend fun KChromeScripting.removeCSS(
	origin: StyleOrigin? = null,
	target: InjectionTarget,
	files: JsReadonlyArray<String>? = null,
): Unit =
	removeCSS(
		CSSInjection(
			target = target,
			files = files,
			origin = origin
		)
	)