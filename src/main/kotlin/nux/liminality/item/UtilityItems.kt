package nux.liminality.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import nux.liminality.util.ItemRegistrator
import nux.liminality.util.ItemEntry

object UtilityItems : ItemRegistrator {
    override val items: List<ItemEntry> = listOf(

        ItemEntry("tape", Item(FabricItemSettings()))

    )
}