package de.fabianbonk.aoc2016

import de.fabianbonk.CustomExercise

object Day02 : CustomExercise<List<String>, String>("Bathroom Security") {
    override fun partOne(input: List<String>) =
        buildString {
            input.fold(1 to 2) { prev, line ->
                line.fold(prev) { (x, y), c ->
                    when (c) {
                        'U' -> (x - 1).coerceAtLeast(0) to y
                        'D' -> (x + 1).coerceAtMost(2) to y
                        'L' -> x to (y - 1).coerceAtLeast(1)
                        'R' -> x to (y + 1).coerceAtMost(3)
                        else -> throw IllegalArgumentException("Unexpected direction $c.")
                    }
                }.also { (x, y) ->
                    append("${(x * 3) + y}")
                }
            }
        }

    private val grid = listOf(
        listOf(null, null, '1', null, null),
        listOf(null, '2', '3', '4', null),
        listOf('5', '6', '7', '8', '9'),
        listOf(null, 'A', 'B', 'C', null),
        listOf(null, null, 'D', null, null),
    )

    override fun partTwo(input: List<String>): String =
        buildString {
            input.fold(2 to 0) { prev, line ->
                line.fold(prev) { (x, y), c ->
                    val (newX, newY) = when (c) {
                        'U' -> (x - 1).coerceAtLeast(0) to y
                        'D' -> (x + 1).coerceAtMost(4) to y
                        'L' -> x to (y - 1).coerceAtLeast(0)
                        'R' -> x to (y + 1).coerceAtMost(4)
                        else -> throw IllegalArgumentException("Unexpected direction $c.")
                    }
                    if (grid[newX][newY] != null) {
                        newX to newY
                    } else {
                        x to y
                    }
                }.also { (x, y) ->
                    append(grid[x][y]!!)
                }
            }
        }
}
