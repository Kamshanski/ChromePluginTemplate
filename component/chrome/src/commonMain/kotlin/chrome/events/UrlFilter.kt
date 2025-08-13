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

fun UrlFilter(
	/**
	 * Matches if the host part of the URL is an IP address and is contained in any of the CIDR blocks specified in the array.
	 * @since Chrome 123
	 */
	cidrBlocks: JsReadonlyArray<String>? = null,
	/** Matches if the scheme of the URL is equal to any of the schemes specified in the array. */
	schemes: JsReadonlyArray<String>? = null,
	/** Matches if the URL (without fragment identifier) matches a specified regular expression. Port numbers are stripped from the URL if they match the default port number. The regular expressions use the RE2 syntax. */
	urlMatches: String? = null,
	/** Matches if the path segment of the URL contains a specified string. */
	pathContains: String? = null,
	/** Matches if the host name of the URL ends with a specified string. */
	hostSuffix: String? = null,
	/** Matches if the host name of the URL starts with a specified string. */
	hostPrefix: String? = null,
	/** Matches if the host name of the URL contains a specified string. To test whether a host name component has a prefix 'foo', use hostContains: '.foo'. This matches 'www.foobar.com' and 'foo.com', because an implicit dot is added at the beginning of the host name. Similarly, hostContains can be used to match against component suffix ('foo.') and to exactly match against components ('.foo.'). Suffix- and exact-matching for the last components need to be done separately using hostSuffix, because no implicit dot is added at the end of the host name. */
	hostContains: String? = null,
	/** Matches if the URL (without fragment identifier) contains a specified string. Port numbers are stripped from the URL if they match the default port number. */
	urlContains: String? = null,
	/** Matches if the query segment of the URL ends with a specified string. */
	querySuffix: String? = null,
	/** Matches if the URL (without fragment identifier) starts with a specified string. Port numbers are stripped from the URL if they match the default port number. */
	urlPrefix: String? = null,
	/** Matches if the host name of the URL is equal to a specified string. */
	hostEquals: String? = null,
	/** Matches if the URL (without fragment identifier) is equal to a specified string. Port numbers are stripped from the URL if they match the default port number. */
	urlEquals: String? = null,
	/** Matches if the query segment of the URL contains a specified string. */
	queryContains: String? = null,
	/** Matches if the path segment of the URL starts with a specified string. */
	pathPrefix: String? = null,
	/** Matches if the path segment of the URL is equal to a specified string. */
	pathEquals: String? = null,
	/** Matches if the path segment of the URL ends with a specified string. */
	pathSuffix: String? = null,
	/** Matches if the query segment of the URL is equal to a specified string. */
	queryEquals: String? = null,
	/** Matches if the query segment of the URL starts with a specified string. */
	queryPrefix: String? = null,
	/** Matches if the URL (without fragment identifier) ends with a specified string. Port numbers are stripped from the URL if they match the default port number. */
	urlSuffix: String? = null,
	/** Matches if the port of the URL is contained in any of the specified port lists. For example `[80, 443, [1000, 1200]]` matches all requests on port 80, 443 and in the range 1000-1200. */
	ports: Array<Int>? = null,
	/** Matches if the port of the URL is contained in any of the specified port lists. For example `[80, 443, [1000, 1200]]` matches all requests on port 80, 443 and in the range 1000-1200. */
	portsRanges: Array<IntArray>? = null,
	/** Matches if the URL without query segment and fragment identifier matches a specified regular expression. Port numbers are stripped from the URL if they match the default port number. The regular expressions use the RE2 syntax. */
	originAndPathMatches: String? = null,
): UrlFilter =
	js("{}").unsafeCast<UrlFilter>().apply {
		this.cidrBlocks = cidrBlocks
		this.schemes = schemes
		this.urlMatches = urlMatches
		this.pathContains = pathContains
		this.hostSuffix = hostSuffix
		this.hostPrefix = hostPrefix
		this.hostContains = hostContains
		this.urlContains = urlContains
		this.querySuffix = querySuffix
		this.urlPrefix = urlPrefix
		this.hostEquals = hostEquals
		this.urlEquals = urlEquals
		this.queryContains = queryContains
		this.pathPrefix = pathPrefix
		this.pathEquals = pathEquals
		this.pathSuffix = pathSuffix
		this.queryEquals = queryEquals
		this.queryPrefix = queryPrefix
		this.urlSuffix = urlSuffix
		this.ports = if (ports == null && portsRanges == null) {
			null
		} else {
			(ports ?: emptyArray()) + (portsRanges ?: emptyArray())
		}
		this.originAndPathMatches = originAndPathMatches
	}