package de.fabianbonk.aoc2017

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day01Test : Test<Day01, List<Int>>(1228, 1238, { map { it.toInt() - 48 } }) {
    override val partOneInputs = listOf(
        arguments(3, listOf(1, 1, 2, 2), "tutorial input 1"),
        arguments(4, listOf(1, 1, 1, 1), "tutorial input 2"),
        arguments(0, listOf(1, 2, 3, 4), "tutorial input 3"),
        arguments(9, listOf(9, 1, 2, 1, 2, 1, 2, 9), "tutorial input 4"),
    )

    override val partTwoInputs = listOf(
        arguments(6, listOf(1, 2, 1, 2), "tutorial input 1"),
        arguments(0, listOf(1, 2, 2, 1), "tutorial input 2"),
        arguments(4, listOf(1, 2, 3, 4, 2, 5), "tutorial input 3"),
        arguments(12, listOf(1, 2, 3, 1, 2, 3), "tutorial input 4"),
        arguments(4, listOf(1, 2, 1, 3, 1, 4, 1, 5), "tutorial input 5"),
    )
}
