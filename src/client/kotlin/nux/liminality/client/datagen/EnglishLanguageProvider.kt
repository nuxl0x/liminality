package nux.liminality.client.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.Registries
import nux.liminality.Liminality.MOD_ID

class EnglishLanguageProvider(output: FabricDataOutput) : FabricLanguageProvider(output, "en_us") {

    val uniqueItems = mapOf<String, String>()

    val liminalityItems = Registries.ITEM.ids
        .filter { it.namespace == MOD_ID }
        .mapNotNull { Registries.ITEM.get(it) }

    fun formatItemName(name: String): String {
        return name.split("_").joinToString(" ") { it ->
            it.replaceFirstChar { it.uppercase() }
        }
    }

    override fun generateTranslations(translationBuilder: TranslationBuilder) {

        liminalityItems.forEach { item ->
            val id = Registries.ITEM.getId(item).path
            val name = uniqueItems[id] ?: formatItemName(id)

            translationBuilder.add(item, name)
        }

    }
}