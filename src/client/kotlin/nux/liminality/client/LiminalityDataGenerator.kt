package nux.liminality.client

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import nux.liminality.client.datagen.EnglishLanguageProvider
import nux.liminality.client.datagen.ModelProvider

object LiminalityDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()

		pack.addProvider(::EnglishLanguageProvider)
		pack.addProvider(::ModelProvider)

	}
}