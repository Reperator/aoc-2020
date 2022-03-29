package de.fabianbonk.aoc2021

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments

class Day02Test : Test<Day02, List<String>>(1459206, 1320534480) {
    private val tutorial = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2",
    )

    override val partOneInputs = listOf(
        Arguments.arguments(150, tutorial, "tutorial input"),
    )

    override val partTwoInputs = listOf(
        Arguments.arguments(900, tutorial, "tutorial input"),
    )
}
