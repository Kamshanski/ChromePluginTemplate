package optin

import org.gradle.api.provider.ListProperty

fun ListProperty<String>.defaultOptInOption() {
	add("kotlin.js.ExperimentalJsCollectionsApi")
}