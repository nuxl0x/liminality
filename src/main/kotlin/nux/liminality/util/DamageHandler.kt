package nux.liminality.util

import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageTypes
import net.minecraft.registry.tag.DamageTypeTags
import net.minecraft.server.network.ServerPlayerEntity
import nux.liminality.effect.NegativeEffects
import nux.liminality.effect.PositiveEffects

object DamageHandler {

    fun handlePlayerDamage(player: ServerPlayerEntity, source: DamageSource, amount: Float): Boolean {
        val clipBoolean = source.isIn(DamageTypeTags.IS_FALL) // 0.5% Chance
                && source.isOf(DamageTypes.IN_WALL) // 5% Chance
                && source.isOf(DamageTypes.CRAMMING) // 50% Chance
                && source.isOf(DamageTypes.BAD_RESPAWN_POINT) // 2.5% Chance
                && source.isOf(DamageTypes.OUT_OF_WORLD) // 10% Chance
                && source.isOf(DamageTypes.FALLING_ANVIL) // 75% Chance

        if (!clipBoolean) return false
        if (player.hasStatusEffect(PositiveEffects.get("stability").effect)) return false

        val multiplier = if (player.hasStatusEffect(NegativeEffects.get("instability").effect)) 2.0f else 1.0f
        val randomFloat = player.random.nextFloat()

        val shouldTeleport = when {
            source.isIn(DamageTypeTags.IS_FALL) -> randomFloat < 0.005f * multiplier
            source.isOf(DamageTypes.IN_WALL) -> randomFloat < 0.05f * multiplier
            source.isOf(DamageTypes.CRAMMING) -> randomFloat < 0.5f * multiplier
            source.isOf(DamageTypes.BAD_RESPAWN_POINT) -> randomFloat < 0.025f * multiplier
            source.isOf(DamageTypes.OUT_OF_WORLD) -> randomFloat < 0.1f * multiplier
            source.isOf(DamageTypes.FALLING_ANVIL) -> randomFloat < if (multiplier != 2.0f) 0.75f else 1.0f

            else -> false
        }

        if (!shouldTeleport) return false



        return true
    }

}