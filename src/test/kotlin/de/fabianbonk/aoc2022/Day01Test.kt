package de.fabianbonk.aoc2022

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day01Test : Test<Day01, List<List<Int>>>(
    74711,
    209481,
    { split("\n\n").map { it.lines().map { line -> line.toInt() } } }
) {
    private val tutorial = listOf(
        listOf(
            1000,
            2000,
            3000,
        ),
        listOf(
            4000,
        ),
        listOf(
            5000,
            6000,
        ),
        listOf(
            7000,
            8000,
            9000,
        ),
        listOf(
            10000,
        ),
    )

    override val partOneInputs = listOf(
        arguments(24000, tutorial, "tutorial input")
    )

    override val partTwoInputs = listOf(
        arguments(45000, tutorial, "tutorial input")
    )
}
