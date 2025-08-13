@file:Suppress("unused")

package dev.kamshanski.chrome.component.chrome.action

import chrome.action.BadgeColorDetails
import chrome.action.BadgeTextDetails
import chrome.action.OpenPopupOptions
import chrome.action.PopupDetails
import chrome.action.TabDetails
import chrome.action.TabIconDetails
import chrome.action.TitleDetails
import chrome.extensiontypes.ColorArray
import org.w3c.dom.ImageData

/**
 * @see chrome.action.ChromeAction.getBadgeBackgroundColor
 * @see TabDetails
 */
suspend fun KChromeAction.getBadgeBackgroundColor(
	/** The ID of the tab to query state for. If no tab is specified, the non-tab-specific state is returned.  */
	tabId: Int?,
): ColorArray = getBadgeBackgroundColor(TabDetails(tabId))

/**
 * @see chrome.action.ChromeAction.getBadgeText
 * @see TabDetails
 */
suspend fun KChromeAction.getBadgeText(
	/** The ID of the tab to query state for. If no tab is specified, the non-tab-specific state is returned.  */
	tabId: Int?,
): String = getBadgeText(TabDetails(tabId))

/**
 * @see chrome.action.ChromeAction.getBadgeTextColor
 * @see TabDetails
 */
suspend fun KChromeAction.getBadgeTextColor(
	/** The ID of the tab to query state for. If no tab is specified, the non-tab-specific state is returned.  */
	tabId: Int?,
): ColorArray = getBadgeTextColor(TabDetails(tabId))

/**
 * @see chrome.action.ChromeAction.getPopup
 * @see TabDetails
 */
suspend fun KChromeAction.getPopup(
	/** The ID of the tab to query state for. If no tab is specified, the non-tab-specific state is returned.  */
	tabId: Int?,
): String = getPopup(TabDetails(tabId))

/**
 * @see chrome.action.ChromeAction.getTitle
 * @see TabDetails
 */
suspend fun KChromeAction.getTitle(
	/** The ID of the tab to query state for. If no tab is specified, the non-tab-specific state is returned.  */
	tabId: Int?,
): String = getTitle(TabDetails(tabId))

/**
 * @see chrome.action.ChromeAction.openPopup
 * @see OpenPopupOptions
 */
suspend fun KChromeAction.openPopup(
	/** The id of the window to open the action popup in. Defaults to the currently-active window if unspecified.  */
	windowId: Int?,
) = openPopup(OpenPopupOptions(windowId))

/**
 * @see chrome.action.ChromeAction.setBadgeBackgroundColor
 * @see BadgeColorDetails
 */
suspend fun KChromeAction.setBadgeBackgroundColor(
	/** An array of four integers in the range [0,255] that make up the RGBA color of the badge. For example, opaque red is `[255, 0, 0, 255]`. */
	color: ColorArray,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
): Unit = setBadgeBackgroundColor(BadgeColorDetails(color = color, tabId = tabId))

/**
 * @see chrome.action.ChromeAction.setBadgeBackgroundColor
 * @see BadgeColorDetails
 */
suspend fun KChromeAction.setBadgeBackgroundColor(
	/** A string with a CSS value, with opaque red being `#FF0000` or `#F00`. */
	color: String,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
): Unit = setBadgeBackgroundColor(BadgeColorDetails(color = color, tabId = tabId))

/**
 * @see chrome.action.ChromeAction.setBadgeText
 * @see BadgeTextDetails
 */
suspend fun KChromeAction.setBadgeText(
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
	/** Any number of characters can be passed, but only about four can fit in the space. If an empty string (`''`) is passed, the badge text is cleared. If `tabId` is specified and `text` is null, the text for the specified tab is cleared and defaults to the global badge text. */
	text: String? = null,
): Unit = setBadgeText(BadgeTextDetails(tabId = tabId, text = text))

/**
 * @see chrome.action.ChromeAction.setBadgeTextColor
 * @see BadgeColorDetails
 */
suspend fun KChromeAction.setBadgeTextColor(
	/** An array of four integers in the range [0,255] that make up the RGBA color of the badge. For example, opaque red is `[255, 0, 0, 255]`. */
	color: ColorArray,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
): Unit = setBadgeTextColor(BadgeColorDetails(color = color, tabId = tabId))

/**
 * @see chrome.action.ChromeAction.setBadgeTextColor
 * @see BadgeColorDetails
 */
suspend fun KChromeAction.setBadgeTextColor(
	/** A string with a CSS value, with opaque red being `#FF0000` or `#F00`. */
	color: String,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
): Unit = setBadgeTextColor(BadgeColorDetails(color = color, tabId = tabId))

/**
 * @see chrome.action.ChromeAction.setIcon
 * @see TabIconDetails
 */
suspend fun KChromeAction.setIcon(
	/** Either a relative image path or a dictionary {size -> relative image path} pointing to icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.path = foo' is equivalent to 'details.path = {'16': foo}' */
	path: Any? = null,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	tabId: Int? = null,
	/** Either an ImageData object or a dictionary {size -> ImageData} representing icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.imageData = foo' is equivalent to 'details.imageData = {'16': foo}' */
	imageData: ImageData?,
): Unit = setIcon(TabIconDetails(path = path, tabId = tabId, imageData = imageData))

/**
 * @see chrome.action.ChromeAction.setIcon
 * @see TabIconDetails
 */
suspend fun KChromeAction.setIcon(
	/** Either a relative image path or a dictionary {size -> relative image path} pointing to icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.path = foo' is equivalent to 'details.path = {'16': foo}' */
	path: Any? = null,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	tabId: Int? = null,
	/** Either an ImageData object or a dictionary {size -> ImageData} representing icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.imageData = foo' is equivalent to 'details.imageData = {'16': foo}' */
	imageData: Map<Int, ImageData>?,
): Unit = setIcon(TabIconDetails(path = path, tabId = tabId, imageData = imageData))

/**
 * @see chrome.action.ChromeAction.setIcon
 * @see TabIconDetails
 */
suspend fun KChromeAction.setIcon(
	/** Either a relative image path or a dictionary {size -> relative image path} pointing to icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.path = foo' is equivalent to 'details.path = {'16': foo}' */
	path: Any? = null,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	tabId: Int? = null,
	/** Either an ImageData object or a dictionary {size -> ImageData} representing icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.imageData = foo' is equivalent to 'details.imageData = {'16': foo}' */
	imageData: Nothing?,
): Unit = setIcon(TabIconDetails(path = path, tabId = tabId, imageData = imageData))

/**
 * @see chrome.action.ChromeAction.setPopup
 * @see PopupDetails
 */
suspend fun KChromeAction.setPopup(
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed. */
	tabId: Int?,
	/** The html file to show in a popup. If set to the empty string (`''`), no popup is shown. */
	popup: String,
): Unit = setPopup(PopupDetails(tabId = tabId, popup = popup))

/**
 * @see chrome.action.ChromeAction.setTitle
 * @see TitleDetails
 */
suspend fun KChromeAction.setTitle(
	/** The string the action should display when moused over. */
	title: String,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	tabId: Int? = null,
): Unit = setTitle(TitleDetails(title = title, tabId = tabId))