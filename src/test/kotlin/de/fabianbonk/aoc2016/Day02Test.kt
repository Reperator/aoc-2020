package de.fabianbonk.aoc2016

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day02Test : CustomTest<Day02, List<String>, String>("35749", "9365C") {
    private val tutorial = listOf("ULL", "RRDDD", "LURDL", "UUUUD")

    override val partOneInputs = listOf(
        arguments("1985", tutorial, "tutorial input 1"),
    )

    override val partTwoInputs = listOf(
        arguments("5DB3", tutorial, "tutorial input 1"),
    )
}
