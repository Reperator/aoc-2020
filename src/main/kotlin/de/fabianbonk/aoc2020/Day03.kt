package de.fabianbonk.aoc2020

import de.fabianbonk.CustomExercise
import de.fabianbonk.toInt

data class Forest(
    val forest: List<List<Boolean>>,
    val height: Int,
    val width: Int,
) {
    fun traverse(slope: Slope) =
        // [0, 0] is not checked in the example; we should start at [right, down]
        (slope.down until height step slope.down).fold(
            Pair(slope.right % width, 0)
        ) { (x, trees), y ->
            Pair((x + slope.right) % width, trees + forest[y][x].toInt())
        }.second

    companion object {
        fun parse(input: String): Forest {
            val lines = input.lines()

            require(lines.isNotEmpty()) { "there must be at least one line" }
            require(lines.all { it.length == lines.first().length }) { "all lines must have the same length" }

            val forest = lines.map { line ->
                line.map { square ->
                    when (square) {
                        '.' -> false
                        '#' -> true
                        else -> throw IllegalArgumentException("unexpected character: $square")
                    }
                }
            }

            return Forest(forest, height = lines.size, width = lines.first().length)
        }
    }
}

data class Slope(
    val right: Int,
    val down: Int,
) {
    init {
        require(down > 0) { "slope must go down" }
    }
}

object Day03 : CustomExercise<Forest, Long>("Toboggan Trajectory") {
    override fun partOne(input: Forest) = input.traverse(Slope(3, 1)).toLong()

    override fun partTwo(input: Forest) =
        listOf(
            Slope(1, 1),
            Slope(3, 1),
            Slope(5, 1),
            Slope(7, 1),
            Slope(1, 2),
        ).fold(1L) { acc, slope ->
            acc * input.traverse(slope)
        }
}
