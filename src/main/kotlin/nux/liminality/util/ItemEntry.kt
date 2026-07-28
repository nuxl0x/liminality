package nux.liminality.util

import net.minecraft.data.client.Model
import net.minecraft.item.Item
import net.minecraft.util.Identifier

data class ItemEntry(
    val id: Identifier,
    val item: Item,
    val model: Model
) {
    constructor(path: String, item: Item, model: Model) : this(path.asId(), item, model)
}