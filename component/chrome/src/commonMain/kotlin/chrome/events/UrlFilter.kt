package chrome.events

import kotlin.js.collections.JsReadonlyArray

/** Filters URLs for various criteria. See event filtering. All criteria are case sensitive. */
external interface UrlFilter {

	/**
	 * Matches if the host part of the URL is an IP address and is contained in any of the CIDR blocks specified in the array.
	 * @since Chrome 123
	 */
	var cidrBlocks: JsReadonlyArray<String>?

	/** Matches if the scheme of the URL is equal to any of the schemes specified in the array. */
	var schemes: JsReadonlyArray<String>?

	/** Matches if the URL (without fragment identifier) matches a specified regular expression. Port numbers are stripped from the URL if they match the default port number. The regular expressions use the RE2 syntax. */
	var urlMatches: String?

	/** Matches if the path segment of the URL contains a specified string. */
	var pathContains: String?

	/** Matches if the host name of the URL ends with a specified string. */
	var hostSuffix: String?

	/** Matches if the host name of the URL starts with a specified string. */
	var hostPrefix: String?

	/** Matches if the host name of the URL contains a specified string. To test whether a host name component has a prefix 'foo', use hostContains: '.foo'. This matches 'www.foobar.com' and 'foo.com', because an implicit dot is added at the beginning of the host name. Similarly, hostContains can be used to match against component suffix ('foo.') and to exactly match against components ('.foo.'). Suffix- and exact-matching for the last components need to be done separately using hostSuffix, because no implicit dot is added at the end of the host name. */
	var hostContains: String?

	/** Matches if the URL (without fragment identifier) contains a specified string. Port numbers are stripped from the URL if they match the default port number. */
	var urlContains: String?

	/** Matches if the query segment of the URL ends with a specified string. */
	var querySuffix: String?

	/** Matches if the URL (without fragment identifier) starts with a specified string. Port numbers are stripped from the URL if they match the default port number. */
	var urlPrefix: String?

	/** Matches if the host name of the URL is equal to a specified string. */
	var hostEquals: String?

	/** Matches if the URL (without fragment identifier) is equal to a specified string. Port numbers are stripped from the URL if they match the default port number. */
	var urlEquals: String?

	/** Matches if the query segment of the URL contains a specified string. */
	var queryContains: String?

	/** Matches if the path segment of the URL starts with a specified string. */
	var pathPrefix: String?

	/** Matches if the path segment of the URL is equal to a specified string. */
	var pathEquals: String?

	/** Matches if the path segment of the URL ends with a specified string. */
	var pathSuffix: String?

	/** Matches if the query segment of the URL is equal to a specified string. */
	var queryEquals: String?

	/** Matches if the query segment of the URL starts with a specified string. */
	var queryPrefix: String?

	/** Matches if the URL (without fragment identifier) ends with a specified string. Port numbers are stripped from the URL if they match the default port number. */
	var urlSuffix: String?

	/** Matches if the port of the URL is contained in any of the specified port lists. For example `[80, 443, [1000, 1200]]` matches all requests on port 80, 443 and in the range 1000-1200. */
	var ports: Array<Any /* number | number[] */>?

	/** Matches if the URL without query segment and fragment identifier matches a specified regular expression. Port numbers are stripped from the URL if they match the default port number. The regular expressions use the RE2 syntax. */
	var originAndPathMatches: String?
}