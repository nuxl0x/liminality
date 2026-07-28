package nux.liminality.util

import net.minecraft.block.Block
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.util.Identifier

data class BlockEntry(
    val id: Identifier,
    val block: Block,
    val generatorModel: (BlockStateModelGenerator, Block) -> Unit = { generator, block ->
        generator.registerSimpleCubeAll(block)
    }
) {
    constructor(
        path: String,
        block: Block,
        generatorModel: (BlockStateModelGenerator, Block) -> Unit = { generator, block ->
            generator.registerSimpleCubeAll(block)
        }
    ) : this(path.asId(), block, generatorModel)
}