package nux.liminality.util.block

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.BlockItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

interface BlockRegistrator {
    val blocks: List<BlockEntry>

    fun get(path: String): BlockEntry = blocks.first { it.id.path == path }

    fun register() {
        blocks.forEach { block ->
            Registry.register(
                Registries.BLOCK,
                block.id,
                block.block
            )

            Registry.register(
                Registries.ITEM,
                block.id,
                BlockItem(block.block, FabricItemSettings())
            )
        }
    }
}