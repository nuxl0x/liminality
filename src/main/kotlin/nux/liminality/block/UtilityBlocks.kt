package nux.liminality.block

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Blocks
import net.minecraft.data.client.BlockStateVariant
import net.minecraft.data.client.Model
import net.minecraft.data.client.ModelIds
import net.minecraft.data.client.Models
import net.minecraft.data.client.MultipartBlockStateSupplier
import net.minecraft.data.client.TextureKey
import net.minecraft.data.client.TextureMap
import net.minecraft.data.client.VariantSettings
import net.minecraft.state.property.Properties
import net.minecraft.util.Identifier
import nux.liminality.block.type.SurfaceWireBlock
import nux.liminality.util.BlockEntry
import nux.liminality.util.BlockRegistrator
import nux.liminality.util.asId
import java.util.Optional

object UtilityBlocks : BlockRegistrator {
    override val blocks: List<BlockEntry> = listOf(

        BlockEntry(
            "blue_tape",
            SurfaceWireBlock(
                AbstractBlock.Settings.create()
                    .noCollision()
                    .breakInstantly()
            )
        ) { gen, block ->

            // 1. Point directly to your manual JSON: assets/liminality/models/block/blue_tape.json
            val blockModelId = "block/blue_tape".asId()

            // 2. Map outward-facing rotations for each face
            val multipart = MultipartBlockStateSupplier.create(block)
                .with(
                    net.minecraft.data.client.When.create().set(Properties.NORTH, true),
                    BlockStateVariant.create().put(VariantSettings.MODEL, blockModelId)
                )
                .with(
                    net.minecraft.data.client.When.create().set(Properties.SOUTH, true),
                    BlockStateVariant.create().put(VariantSettings.MODEL, blockModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180)
                )
                .with(
                    net.minecraft.data.client.When.create().set(Properties.WEST, true),
                    BlockStateVariant.create().put(VariantSettings.MODEL, blockModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270)
                )
                .with(
                    net.minecraft.data.client.When.create().set(Properties.EAST, true),
                    BlockStateVariant.create().put(VariantSettings.MODEL, blockModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                // FLOOR (DOWN): Rotates down to Y = 0.05
                .with(
                    net.minecraft.data.client.When.create().set(Properties.DOWN, true),
                    BlockStateVariant.create().put(VariantSettings.MODEL, blockModelId).put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                // CEILING (UP): Rotates up to Y = 15.95
                .with(
                    net.minecraft.data.client.When.create().set(Properties.UP, true),
                    BlockStateVariant.create().put(VariantSettings.MODEL, blockModelId).put(VariantSettings.X, VariantSettings.Rotation.R270)
                )

            gen.blockStateCollector.accept(multipart)

            // 3. Handheld 2D item model (assets/liminality/textures/item/blue_tape.png)
            val item = block.asItem()
            Models.GENERATED.upload(
                ModelIds.getItemModelId(item),
                TextureMap.layer0(item),
                gen.modelCollector
            )
        }

    )
}