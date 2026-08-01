package nux.liminality.util.item

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

interface ItemRegistrator {
    val items: List<ItemEntry>

    fun get(path: String): ItemEntry = items.first { it.id.path == path }

    fun register() {
        items.forEach { item ->
            Registry.register(Registries.ITEM, item.id, item.item)
        }
    }

}