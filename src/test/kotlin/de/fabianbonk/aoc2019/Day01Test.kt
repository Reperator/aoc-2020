package de.fabianbonk.aoc2019

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day01Test : Test<Day01, List<Int>>(3297896, 4943969, { lines().map { it.toInt() } }) {
    override val partOneInputs = listOf(
        arguments(2, listOf(12), "tutorial input 1"),
        arguments(2, listOf(14), "tutorial input 2"),
        arguments(654, listOf(1969), "tutorial input 3"),
        arguments(33583, listOf(100756), "tutorial input 4"),
    )

    override val partTwoInputs = listOf(
        arguments(2, listOf(14), "tutorial input 1"),
        arguments(966, listOf(1969), "tutorial input 2"),
        arguments(50346, listOf(100756), "tutorial input 3"),
    )
}
