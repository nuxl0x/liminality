package nux.liminality.effect

import nux.liminality.effect.type.StabilityEffect
import nux.liminality.util.effect.EffectEntry
import nux.liminality.util.effect.EffectRegistrator

object PositiveEffects : EffectRegistrator {
    override val effects: List<EffectEntry> = listOf(
        EffectEntry("stability", StabilityEffect)
    )
}