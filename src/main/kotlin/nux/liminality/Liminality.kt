package nux.liminality

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import nux.liminality.item.UtilityItems
import nux.liminality.util.ItemHelper
import org.slf4j.LoggerFactory

object Liminality : ModInitializer {
	const val MOD_ID: String = "liminality"

	private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		LOGGER.info("[$MOD_ID] Maybe we don't have to change...")
		ItemHelper.registerItems()
	}

}
