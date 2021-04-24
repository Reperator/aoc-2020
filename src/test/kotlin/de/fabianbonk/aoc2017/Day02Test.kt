package de.fabianbonk.aoc2017

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day02Test : Test<Day02, List<List<Int>>>(45351, 275, { lines().map { it.split("\t").map { i -> i.toInt() } } }) {
    override val partOneInputs = listOf(
        arguments(
            18,
            listOf(
                listOf(5, 1, 9, 5),
                listOf(7, 5, 3),
                listOf(2, 4, 6, 8),
            ),
            "tutorial input 1"
        ),
    )

    override val partTwoInputs = listOf(
        arguments(
            9,
            listOf(
                listOf(5, 9, 2, 8),
                listOf(9, 4, 7, 3),
                listOf(3, 8, 6, 5),
            ),
            "tutorial input 1"
        ),
    )
}
