package chrome.extension

import chrome.events.Event

external interface OnRequestEvent :
	Event<Function<Unit> /*
	 (
	    (
	        request: any,
	        sender: runtime.MessageSender,
	        sendResponse: (response: any) => void
        ) => void
    )
    |
    (
        (
            sender: runtime.MessageSender,
            sendResponse: (response: any) => void
        ) => void
    ) */> {

}