package nux.liminality.world

import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.world.World
import nux.liminality.util.asId

object Dimensions {

    val dimensionKeys: List<RegistryKey<World>> = listOf(
        RegistryKey.of(RegistryKeys.WORLD, "level_zero".asId()), // Level 0
    )

    fun get(path: String): RegistryKey<World> = dimensionKeys.first { it.value.path == path }

    fun register() {}

}