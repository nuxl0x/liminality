package nux.liminality.client.util

import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Model
import nux.liminality.util.ItemRegistrator

fun ItemModelGenerator.registerAll(registrator: ItemRegistrator, model: Model) {
    registrator.items.forEach { itemEntry ->
        this.register(itemEntry.item, model)
    }
}