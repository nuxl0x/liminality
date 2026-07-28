package nux.liminality.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import nux.liminality.block.UtilityBlocks

object LiminalityClient : ClientModInitializer {
	override fun onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(
			UtilityBlocks.get("blue_tape").block,
			RenderLayer.getCutout()
		)
	}
}