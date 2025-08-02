@file:JsQualifier("chrome.declarativecontent")

package chrome.declarativecontent

import chrome.events.Event

/** Provides the Declarative Event API consisting of addRules, removeRules, and getRules. */
external interface PageChangedEvent : Event<() -> Unit>