package nux.liminality.util

import net.minecraft.block.BlockState
import net.minecraft.registry.RegistryKey
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

object TeleportationHandler {
    fun safeTeleportToBackrooms(
        player: ServerPlayerEntity,
        targetWorldKey: RegistryKey<World>,
        targetX: Double,
        roofY: Int = 120, // Set this to Y level just BELOW your dimension's ceiling
        targetZ: Double
    ) {
        val world = player.server?.getWorld(targetWorldKey) ?: return

        val safePos = findIndoorSafeY(world, BlockPos(targetX.toInt(), roofY, targetZ.toInt()))

        player.teleport(
            world,
            safePos.x + 0.5,
            safePos.y.toDouble(),
            safePos.z + 0.5,
            emptySet(),
            player.yaw,
            player.pitch
        )
    }

    private fun findIndoorSafeY(world: ServerWorld, startPos: BlockPos): BlockPos {
        val mutablePos = startPos.mutableCopy()
        val minY = world.bottomY

        // Scan DOWNWARD from startPos (just below the roof) to the floor
        while (mutablePos.y > minY) {
            if (isSafeIndoorSpot(world, mutablePos)) {
                return mutablePos.toImmutable()
            }
            mutablePos.move(0, -1, 0)
        }

        // Fallback position if no valid floor is found in that column
        return startPos
    }

    private fun isSafeIndoorSpot(world: ServerWorld, pos: BlockPos): Boolean {
        val feet: BlockState = world.getBlockState(pos)
        val head: BlockState = world.getBlockState(pos.up())
        val floor: BlockState = world.getBlockState(pos.down())

        // 1. Both head and feet positions must have empty collision shapes (player can walk into them)
        val feetPassable = feet.getCollisionShape(world, pos).isEmpty
        val headPassable = head.getCollisionShape(world, pos.up()).isEmpty

        // 2. The floor block must be solid (has collision) and not contain fluid (lava/water)
        val solidFloor = !floor.getCollisionShape(world, pos.down()).isEmpty && floor.fluidState.isEmpty

        // 3. Ensure we are inside the structure (no direct sky access)
        val insideStructure = !world.isSkyVisible(pos)

        return feetPassable && headPassable && solidFloor && insideStructure
    }
}