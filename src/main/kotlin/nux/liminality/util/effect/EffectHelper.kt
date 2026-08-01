package nux.liminality.util.effect

import nux.liminality.effect.NegativeEffects
import nux.liminality.effect.PositiveEffects

object EffectHelper {

    fun registerEffects() {
        PositiveEffects.register()
        NegativeEffects.register()
    }

}