package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise
import de.fabianbonk.isEven

data class Pos(
    val x: Int,
    val y: Int,
) {
    fun move(dir: Char) =
        when (dir) {
            '^' -> copy(y = y + 1)
            'v' -> copy(y = y - 1)
            '<' -> copy(x = x - 1)
            '>' -> copy(x = x + 1)
            else -> throw IllegalArgumentException("unexpected direction $dir")
        }
}

object Day03 : Exercise<String>("Perfectly Spherical Houses in a Vacuum") {
    override fun partOne(input: String) =
        input.fold(
            Pos(0, 0).let { it to setOf(it) }
        ) { (pos, visited), dir ->
            val newPos = pos.move(dir)
            newPos to visited + newPos
        }.second.size

    override fun partTwo(input: String) =
        input.foldIndexed(
            Pos(0, 0).let { Triple(it, it, setOf(it)) }
        ) { i, (santaPos, roboPos, visited), dir ->
            if (i.isEven) {
                val newSantaPos = santaPos.move(dir)
                Triple(newSantaPos, roboPos, visited + newSantaPos)
            } else {
                val newRoboPos = roboPos.move(dir)
                Triple(santaPos, newRoboPos, visited + newRoboPos)
            }
        }.third.size
}
