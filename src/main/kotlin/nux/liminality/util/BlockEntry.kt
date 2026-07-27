package nux.liminality.util

import net.minecraft.block.Block
import net.minecraft.util.Identifier

data class BlockEntry(
    val id: Identifier,
    val block: Block
)