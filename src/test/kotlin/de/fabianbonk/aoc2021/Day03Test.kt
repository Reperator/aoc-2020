package de.fabianbonk.aoc2021

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day03Test : Test<Day03, List<String>>(3885894, 4375225) {
    private val tutorial = listOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010",
    )

    override val partOneInputs = listOf(
        arguments(198, tutorial, "tutorial input")
    )

    override val partTwoInputs = listOf(
        arguments(230, tutorial, "tutorial input")
    )
}
