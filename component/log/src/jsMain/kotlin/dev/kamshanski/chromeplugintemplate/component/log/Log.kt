package dev.kamshanski.chromeplugintemplate.component.log

enum class LogL {
	INFO,
	WARNING,
	ERROR,
}

fun log(level: LogL, msg: String) {
	when (level) {
		LogL.INFO    -> console.log(msg)
		LogL.WARNING -> console.warn(msg)
		LogL.ERROR   -> console.error(msg)
	}
}

inline fun e(block: () -> String) {
	log(LogL.ERROR, block())
}

inline fun w(block: () -> String) {
	log(LogL.WARNING, block())
}

inline fun i(block: () -> String) {
	log(LogL.INFO, block())
}

inline fun <T> T.e(block: (T) -> String): T {
	log(LogL.ERROR, block(this))
	return this
}

inline fun <T> T.w(block: (T) -> String): T {
	log(LogL.WARNING, block(this))
	return this
}

inline fun <T> T.i(block: (T) -> String): T {
	log(LogL.INFO, block(this))
	return this
}