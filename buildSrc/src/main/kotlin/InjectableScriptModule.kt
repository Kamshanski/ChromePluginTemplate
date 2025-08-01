internal data class InjectableScriptModule(val moduleName: String, val distributionOutputFolder: String) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as InjectableScriptModule

		return moduleName == other.moduleName
	}

	override fun hashCode(): Int {
		return moduleName.hashCode()
	}
}