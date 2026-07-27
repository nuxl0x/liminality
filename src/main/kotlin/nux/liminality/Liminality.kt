package nux.liminality

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object Liminality : ModInitializer {
	const val MOD_ID: String = "liminality"

	private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		LOGGER.info("[$MOD_ID] Maybe we don't have to change...")
	}

	fun id(path: String): Identifier = Identifier(MOD_ID, path)
}
