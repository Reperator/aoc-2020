package de.fabianbonk.aoc2018

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day01Test : Test<Day01, List<Int>>(406, 312, { lines().map { it.toInt() } }) {
    override val partOneInputs = listOf(
        arguments(3, listOf(+1, -2, +3, +1), "tutorial input 1"),
    )

    override val partTwoInputs = listOf(
        arguments(0, listOf(+1, -1), "tutorial input 1"),
        arguments(10, listOf(+3, +3, +4, -2, -4), "tutorial input 2"),
        arguments(5, listOf(-6, +3, +8, +5, -6), "tutorial input 3"),
        arguments(14, listOf(+7, +7, -2, -7, -4), "tutorial input 4"),
    )
}
