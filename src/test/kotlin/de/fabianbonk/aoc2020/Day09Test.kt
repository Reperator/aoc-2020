package de.fabianbonk.aoc2020

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day09Test : CustomTest<Day09, Pair<List<Long>, Int>, Long>(
    31161678L,
    5453868L,
    { lines().map { it.toLong() } to 50 }
) {
    private val tutorial = listOf(
        35L,
        20L,
        15L,
        25L,
        47L,
        40L,
        62L,
        55L,
        65L,
        95L,
        102L,
        117L,
        150L,
        182L,
        127L,
        219L,
        299L,
        277L,
        309L,
        576L,
    ) to 5

    override val partOneInputs = listOf(
        arguments(127L, tutorial, "tutorial input"),
    )

    override val partTwoInputs = listOf(
        arguments(62L, tutorial, "tutorial input"),
    )
}
