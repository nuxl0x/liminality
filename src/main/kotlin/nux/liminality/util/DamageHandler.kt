package nux.liminality.util

import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageTypes
import net.minecraft.registry.tag.DamageTypeTags
import net.minecraft.server.network.ServerPlayerEntity

object DamageHandler {

    fun handlePlayerDamage(player: ServerPlayerEntity, source: DamageSource, amount: Float): Boolean {
        if (!source.isIn(DamageTypeTags.IS_FALL) && !source.isOf(DamageTypes.IN_WALL)) {}
    }

}