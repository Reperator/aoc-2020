package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day01Test : Test<Day01, List<Int>>(539851, 212481360, { lines().map(Integer::parseInt) }) {
    private val tutorial = listOf(1721, 979, 366, 299, 675, 1456)

    override val partOneInputs = listOf(
        arguments(514579, tutorial, "tutorial input"),
        arguments(40000, listOf(20, 2000, 20, 2000), "duplicate numbers"),
        arguments(2019, listOf(1, 2019), "only two numbers"),
    )

    override val partOneInvalidInputs = listOf(
        Pair(emptyList(), "not enough elements (0)"),
        Pair(listOf(1), "not enough elements (1)"),
        Pair(listOf(1, 2), "small elements"),
        Pair(listOf(100000, 200000), "large elements"),
        Pair(listOf(1, 200000), "small and large elements"),
    )

    override val partTwoInputs = listOf(
        arguments(241861950, tutorial, "tutorial input"),
        arguments(200000, listOf(10, 11, 2000, 10, 100, 2000), "duplicate numbers"),
        arguments(2018, listOf(2018, 1, 1), "only three numbers"),
        arguments(20000000, listOf(11, 20, 1000, 1000, 100000, 10000), "two uppers needed"),
        arguments(200000, listOf(10, 10, 11, 2000, 10000, 1000000), "two lowers needed"),
    )

    override val partTwoInvalidInputs = listOf(
        Pair(emptyList(), "not enough elements (0)"),
        Pair(listOf(1), "not enough elements (1)"),
        Pair(listOf(1, 2), "not enough elements (2)"),
        Pair(listOf(1, 2, 3), "small elements"),
        Pair(listOf(100000, 200000, 300000), "large elements"),
        Pair(listOf(1, 200000, 3), "small and large elements"),
        Pair(listOf(1, 20, 11, 1000, 100000), "two uppers needed"),
        Pair(listOf(1, 10, 11, 2000, 100000), "two lowers needed"),
    )
}
