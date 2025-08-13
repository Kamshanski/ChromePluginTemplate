package chrome.extension

external interface LastError {

	/** Description of the error that has taken place. */
	var message: String
}

fun LastError(
	/** Description of the error that has taken place. */
	message: String,
): LastError =
	js("{}").unsafeCast<LastError>().apply {
		this.message = message
	}