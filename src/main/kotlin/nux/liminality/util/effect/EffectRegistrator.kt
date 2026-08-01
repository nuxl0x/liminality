package nux.liminality.util.effect

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

interface EffectRegistrator {
    val effects: List<EffectEntry>

    fun get(path: String): EffectEntry = effects.first { it.id.path == path }

    fun register() {
        effects.forEach { effect ->
            Registry.register(
                Registries.STATUS_EFFECT,
                effect.id,
                effect.effect
            )
        }
    }

}