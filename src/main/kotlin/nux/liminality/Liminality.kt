package nux.liminality

import net.fabricmc.api.ModInitializer
import nux.liminality.util.block.BlockHelper
import nux.liminality.util.item.ItemHelper
import nux.liminality.world.Dimensions
import org.slf4j.LoggerFactory

object Liminality : ModInitializer {
	const val MOD_ID: String = "liminality"

	private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		LOGGER.info("[$MOD_ID] Maybe we don't have to change...")
		ItemHelper.registerItems()
		BlockHelper.registerBlocks()
		Dimensions.register()
	}

}
