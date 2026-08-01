package nux.liminality.client.datagen

object EnglishLanguageMaps {

    val effects = mapOf(
        "effect.liminality.stability" to "Stability",
        "effect.liminality.instability" to "Instability"
    )

    fun getMaps(): List<Map<String, String>> {
        return listOf(
            effects
        )
    }

}