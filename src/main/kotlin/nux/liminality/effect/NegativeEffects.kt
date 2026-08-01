package nux.liminality.effect

import nux.liminality.effect.type.InstabilityEffect
import nux.liminality.util.effect.EffectEntry
import nux.liminality.util.effect.EffectRegistrator

object NegativeEffects : EffectRegistrator {
    override val effects: List<EffectEntry> = listOf(
        EffectEntry("instability", InstabilityEffect)
    )
}