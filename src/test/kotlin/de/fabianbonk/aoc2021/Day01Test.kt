package de.fabianbonk.aoc2021

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day01Test : Test<Day01, List<Int>>(1715, 1739, { lines().map(Integer::parseInt) }) {
    private val tutorial = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

    override val partOneInputs = listOf(
        arguments(7, tutorial, "tutorial input"),
    )

    override val partTwoInputs = listOf(
        arguments(5, tutorial, "tutorial input"),
    )
}
