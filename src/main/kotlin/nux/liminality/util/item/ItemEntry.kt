package nux.liminality.util.item

import net.minecraft.data.client.Model
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import nux.liminality.util.asId

data class ItemEntry(
    val id: Identifier,
    val item: Item,
    val model: Model
) {
    constructor(path: String, item: Item, model: Model) : this(path.asId(), item, model)
}