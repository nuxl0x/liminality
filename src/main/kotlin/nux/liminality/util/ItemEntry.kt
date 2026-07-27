package nux.liminality.util

import net.minecraft.item.Item
import net.minecraft.util.Identifier

data class ItemEntry(
    val id: Identifier,
    val item: Item,
) {
    constructor(path: String, item: Item) : this(path.asId(), item)
}