package chrome.runtime

@Suppress("unused")
external interface ManifestBase : Manifest {

	// Required
	override var manifest_version: Int
	var name: String
	var version: String

	// Recommended
	var default_locale: String?
	var description: String?
	var icons: ManifestIcons?

	// Optional
	var author: Author?
	var background_page: String?
	var chrome_settings_overrides: ChromeSettingsOverrides?
	var chrome_ui_overrides: ChromeUiOverrides?
	var chrome_url_overrides: ChromeUrlOverrides?
	var commands: Commands?
	var content_capabilities: ContentCapabilities?
	var converted_from_user_script: Boolean?
	var current_locale: String?
	var devtools_page: String?
	var event_rules: Array<EventRule>?
	var externally_connectable: ExternallyConnectable?
	var file_browser_handlers: Array<FileBrowserHandler>?
	var file_system_provider_capabilities: FileSystemProviderCapabilities?
	var homepage_url: String?
	var import: Array<Import>?
	var export: Export?
	var incognito: String?
	var input_components: Array<InputComponent>?
	var key: String?
	var minimum_chrome_version: String?
	var nacl_modules: Array<NaclModule>?
	var oauth2: Oauth2?
	var offline_enabled: Boolean?
	var omnibox: Omnibox?
	var options_page: String?
	var options_ui: OptionsUi?
	var platforms: Array<Platform>?
	var plugins: Array<Plugin>?
	var requirements: Requirements?
	var sandbox: Sandbox?
	var short_name: String?
	var spellcheck: Spellcheck?
	var storage: Storage?
	var tts_engine: TtsEngine?
	var update_url: String?
	var version_name: String?

	operator fun get(key: String): Any?

	operator fun set(key: String, value: Any?)
}