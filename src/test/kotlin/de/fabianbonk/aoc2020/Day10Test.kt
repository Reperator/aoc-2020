package de.fabianbonk.aoc2020

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day10Test : CustomTest<Day10, List<Int>, Long>(2414L, 21156911906816L, { lines().map { it.toInt() } }) {
    private val tutorial1 = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)

    private val tutorial2 = listOf(
        28,
        33,
        18,
        42,
        31,
        14,
        46,
        20,
        48,
        47,
        24,
        23,
        49,
        45,
        19,
        38,
        39,
        11,
        1,
        32,
        25,
        35,
        8,
        17,
        7,
        9,
        4,
        2,
        34,
        10,
        3
    )

    override val partOneInputs = listOf(
        arguments(35L, tutorial1, "tutorial input 1"),
        arguments(220L, tutorial2, "tutorial input 2"),
    )

    override val partTwoInputs = listOf(
        arguments(8L, tutorial1, "tutorial input 1"),
        arguments(19208L, tutorial2, "tutorial input 2"),
    )
}
