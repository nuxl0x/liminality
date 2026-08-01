package nux.liminality.util.effect

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.util.Identifier
import nux.liminality.util.asId

data class EffectEntry (
    val id: Identifier,
    val effect: StatusEffect
) {
    constructor(path: String, effect: StatusEffect) : this(path.asId(), effect)
}