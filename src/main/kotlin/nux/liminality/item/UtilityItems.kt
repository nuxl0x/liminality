package nux.liminality.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.data.client.Models
import net.minecraft.item.Item
import nux.liminality.util.item.ItemRegistrator
import nux.liminality.util.item.ItemEntry

object UtilityItems : ItemRegistrator {
    override val items: List<ItemEntry> = listOf(

        ItemEntry("duct_tape", Item(FabricItemSettings()), Models.GENERATED)

    )
}