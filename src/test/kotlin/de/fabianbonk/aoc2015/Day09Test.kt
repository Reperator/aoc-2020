package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day09Test : Test<Day09, List<String>>(207, 804) {
    private val tutorial = listOf(
        "London to Dublin = 464",
        "London to Belfast = 518",
        "Dublin to Belfast = 141",
    )

    override val partOneInputs = listOf(
        arguments(605, tutorial, "tutorial input")
    )

    override val partTwoInputs = listOf(
        arguments(982, tutorial, "tutorial input")
    )
}
