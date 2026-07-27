package nux.liminality.util

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

interface ItemRegistrator {
    val items: List<ItemEntry>

    fun register() {
        items.forEach { item ->
            Registry.register(Registries.ITEM, item.id, item.item)
        }
    }

}