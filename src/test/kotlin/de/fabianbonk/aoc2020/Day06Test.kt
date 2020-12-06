package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day06Test : Test<Day06, List<List<String>>>(6885, 3550, { split("\n\n").map { it.lines() } }) {
    override val partOneInputs = listOf(
        arguments(
            11,
            listOf(
                listOf("abc"),
                listOf("a", "b", "c"),
                listOf("ab", "ac"),
                listOf("a", "a", "a", "a"),
                listOf("b"),
            ),
            "tutorial input",
        )
    )

    override val partTwoInputs = listOf(
        arguments(
            6,
            listOf(
                listOf("abc"),
                listOf("a", "b", "c"),
                listOf("ab", "ac"),
                listOf("a", "a", "a", "a"),
                listOf("b"),
            ),
            "tutorial input",
        )
    )
}
