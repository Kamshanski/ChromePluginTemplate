package chrome.action

import org.w3c.dom.ImageData

fun TabIconDetails(
	/** Either a relative image path or a dictionary {size -> relative image path} pointing to icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.path = foo' is equivalent to 'details.path = {'16': foo}' */
	path: Any? = null,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	tabId: Int? = null,
	/** Either an ImageData object or a dictionary {size -> ImageData} representing icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.imageData = foo' is equivalent to 'details.imageData = {'16': foo}' */
	imageData: ImageData?,
): TabIconDetails =
	js("{}").unsafeCast<TabIconDetails>().apply {
		this.path = path
		this.tabId = tabId
		this.imageData = imageData
	}

fun TabIconDetails(
	/** Either a relative image path or a dictionary {size -> relative image path} pointing to icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.path = foo' is equivalent to 'details.path = {'16': foo}' */
	path: Any? = null,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	tabId: Int? = null,
	/** Either an ImageData object or a dictionary {size -> ImageData} representing icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.imageData = foo' is equivalent to 'details.imageData = {'16': foo}' */
	imageData: Map<Int, ImageData>?,
): TabIconDetails =
	js("{}").unsafeCast<TabIconDetails>().apply {
		this.path = path
		this.tabId = tabId
		this.imageData = imageData?.asJsReadonlyMapView()
	}

fun TabIconDetails(
	/** Either a relative image path or a dictionary {size -> relative image path} pointing to icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.path = foo' is equivalent to 'details.path = {'16': foo}' */
	path: Any? = null,
	/** Limits the change to when a particular tab is selected. Automatically resets when the tab is closed.  */
	tabId: Int? = null,
	/** Either an ImageData object or a dictionary {size -> ImageData} representing icon to be set. If the icon is specified as a dictionary, the actual image to be used is chosen depending on screen's pixel density. If the number of image pixels that fit into one screen space unit equals `scale`, then image with size `scale` \* n will be selected, where n is the size of the icon in the UI. At least one image must be specified. Note that 'details.imageData = foo' is equivalent to 'details.imageData = {'16': foo}' */
	imageData: Nothing?,
): TabIconDetails =
	js("{}").unsafeCast<TabIconDetails>().apply {
		this.path = path
		this.tabId = tabId
		this.imageData = imageData
	}