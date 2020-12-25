package de.fabianbonk.aoc2020

import de.fabianbonk.Exercise
import de.fabianbonk.iterate
import kotlin.math.absoluteValue

enum class Dir {
    North, East, South, West;

    fun turn(right: Boolean) =
        values()[(ordinal + (if (right) 1 else -1)) and 0b11]
}

data class Ship(
    val x: Int,
    val y: Int,
    val facing: Dir = Dir.East,
) {
    val manhattan: Int
        get() = x.absoluteValue + y.absoluteValue

    companion object {
        val origin = Ship(0, 0)
    }
}

data class Waypoint(
    val dx: Int,
    val dy: Int,
    val ship: Ship,
) {
    companion object {
        val origin = Waypoint(10, 1, Ship.origin)
    }
}

sealed class ShipInstr {
    abstract fun walk(from: Ship): Ship

    abstract fun waypoint(from: Waypoint): Waypoint

    companion object {
        fun parse(input: String): ShipInstr {
            val dist = input.substring(1).toInt()
            return when (val instr = input[0]) {
                'N' -> Cardinal(Dir.North, dist)
                'E' -> Cardinal(Dir.East, dist)
                'S' -> Cardinal(Dir.South, dist)
                'W' -> Cardinal(Dir.West, dist)
                'R' -> Turn(true, dist / 90).also { require(dist % 90 == 0) { "only multiples of 90° are allowed" } }
                'L' -> Turn(false, dist / 90).also { require(dist % 90 == 0) { "only multiples of 90° are allowed" } }
                'F' -> Forward(dist)
                else -> throw IllegalArgumentException("Unknown instruction $instr")
            }
        }
    }
}

data class Cardinal(
    val dir: Dir,
    val dist: Int,
) : ShipInstr() {
    override fun walk(from: Ship) =
        when (dir) {
            Dir.North -> from.copy(y = from.y + dist)
            Dir.East -> from.copy(x = from.x + dist)
            Dir.South -> from.copy(y = from.y - dist)
            Dir.West -> from.copy(x = from.x - dist)
        }

    override fun waypoint(from: Waypoint): Waypoint =
        when (dir) {
            Dir.North -> from.copy(dy = from.dy + dist)
            Dir.East -> from.copy(dx = from.dx + dist)
            Dir.South -> from.copy(dy = from.dy - dist)
            Dir.West -> from.copy(dx = from.dx - dist)
        }
}

data class Turn(
    val right: Boolean,
    val n: Int,
) : ShipInstr() {
    override fun walk(from: Ship) =
        from.copy(facing = from.facing.iterate(times = n) { it.turn(right) })

    override fun waypoint(from: Waypoint): Waypoint {
        val (dx, dy) = (from.dx to from.dy).iterate(times = n) { (dx, dy) ->
            if (right) dy to -dx else -dy to dx
        }
        return from.copy(dx = dx, dy = dy)
    }
}

data class Forward(
    val n: Int,
) : ShipInstr() {
    override fun walk(from: Ship) =
        when (from.facing) {
            Dir.North -> from.copy(y = from.y + n)
            Dir.East -> from.copy(x = from.x + n)
            Dir.South -> from.copy(y = from.y - n)
            Dir.West -> from.copy(x = from.x - n)
        }

    override fun waypoint(from: Waypoint) =
        from.iterate(times = n) {
            it.copy(ship = Ship(it.ship.x + it.dx, it.ship.y + it.dy))
        }
}

object Day12 : Exercise<List<String>>("Rain Risk") {
    override fun partOne(input: List<String>) =
        input.fold(Ship.origin) { pos, instr ->
            ShipInstr.parse(instr).walk(pos)
        }.manhattan

    override fun partTwo(input: List<String>) =
        input.fold(Waypoint.origin) { waypoint, instr ->
            ShipInstr.parse(instr).waypoint(waypoint)
        }.ship.manhattan
}
