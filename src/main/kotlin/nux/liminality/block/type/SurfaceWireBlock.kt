package nux.liminality.block.type

import net.minecraft.block.LichenGrower
import net.minecraft.block.MultifaceGrowthBlock


class SurfaceWireBlock(settings: Settings) : MultifaceGrowthBlock(settings) {
    // Standard LichenGrower logic isn't needed if it doesn't spread like Sculk/Glow Lichen
    override fun getGrower(): LichenGrower? = null
}