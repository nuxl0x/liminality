package nux.liminality.util

import net.minecraft.util.Identifier
import nux.liminality.Liminality.MOD_ID

fun String.asId(): Identifier = Identifier(MOD_ID, this)