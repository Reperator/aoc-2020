package de.fabianbonk.aoc2020

import de.fabianbonk.CustomExercise

object Day10 : CustomExercise<List<Int>, Long>("Adapter Array") {
    override fun partOne(input: List<Int>) =
        input.sorted().fold(Triple(0, 0L, 1L)) { (prev, diff1, diff3), v ->
            when (v) {
                prev + 1 -> Triple(v, diff1 + 1, diff3)
                prev + 3 -> Triple(v, diff1, diff3 + 1)
                else -> throw IllegalArgumentException("Invalid joltage gap of ${v - prev} between $prev and $v")
            }
        }.let { (_, diff1, diff3) ->
            diff1 * diff3
        }

    private fun pathsFrom(index: Int, input: List<Int>, cache: MutableMap<Int, Long>): Long =
        cache[index]
            ?: input.subList(index + 1, input.size).mapIndexed { i, v ->
                i + index + 1 to v
            }.takeWhile { (_, v) ->
                v <= input[index] + 3
            }.fold(0L) { acc, (i, _) ->
                acc + pathsFrom(i, input, cache)
            }.also {
                cache[index] = it
            }

    override fun partTwo(input: List<Int>): Long =
        pathsFrom(0, listOf(0) + input.sorted(), mutableMapOf(input.size to 1L))
}
