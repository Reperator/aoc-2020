package de.fabianbonk.aoc2016

import de.fabianbonk.Exercise
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

enum class Dir {
    Up, Right, Down, Left;

    fun turn(right: Boolean): Dir =
        values()[(ordinal + (if (right) 1 else -1)) and 0b11]
}

data class Pos(
    val x: Int,
    val y: Int,
    val facing: Dir,
) {
    fun walk(instr: Instr): Pos {
        val dir = facing.turn(instr.right)
        val dist = instr.dist
        val x = when (dir) {
            Dir.Right -> x + dist
            Dir.Left -> x - dist
            else -> x
        }
        val y = when (dir) {
            Dir.Up -> y + dist
            Dir.Down -> y - dist
            else -> y
        }
        return Pos(x, y, dir)
    }

    infix fun lineTo(to: Pos): Set<Pair<Int, Int>> {
        require(x == to.x || y == to.y) { "Positions must be on a line" }

        return if (x == to.x) {
            (min(y, to.y)..max(y, to.y)).mapNotNull {
                if (it == y) null else x to it
            }
        } else {
            (min(x, to.x)..max(x, to.x)).mapNotNull {
                if (it == x) null else it to y
            }
        }.toSet()
    }

    val coords = x to y

    companion object {
        val origin = Pos(0, 0, Dir.Up)
    }
}

data class Instr(
    val right: Boolean,
    val dist: Int,
) {
    companion object {
        fun parse(input: String) = Instr((input[0] == 'R'), input.substring(1).toInt())
    }
}

object Day01 : Exercise<List<String>>("No Time for a Taxicab") {
    override fun partOne(input: List<String>): Int {
        val (x, y) = input.fold(Pos.origin) { pos, instr ->
            pos.walk(Instr.parse(instr))
        }

        return x.absoluteValue + y.absoluteValue
    }

    override fun partTwo(input: List<String>): Int {
        input.fold(Pos.origin to setOf(Pos.origin.coords)) { (pos, visited), instr ->
            val newPos = pos.walk(Instr.parse(instr))

            val line = pos lineTo newPos

            line.forEach {
                if (it in visited) {
                    return it.first.absoluteValue + it.second.absoluteValue
                }
            }

            newPos to visited + line
        }

        throw IllegalArgumentException("No location was visited twice.")
    }
}
