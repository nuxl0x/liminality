package nux.liminality.client.util

import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import nux.liminality.util.block.BlockRegistrator
import nux.liminality.util.item.ItemRegistrator

fun ItemModelGenerator.registerAll(registrator: ItemRegistrator) {
    registrator.items.forEach { itemEntry ->
        this.register(itemEntry.item, itemEntry.model)
    }
}

fun BlockStateModelGenerator.registerAll(registrator: BlockRegistrator) {
    registrator.blocks.forEach { blockEntry ->
        blockEntry.generatorModel(this, blockEntry.block)
    }
}