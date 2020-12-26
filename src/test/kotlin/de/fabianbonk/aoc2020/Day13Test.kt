package de.fabianbonk.aoc2020

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day13Test : CustomTest<Day13, Pair<Int, List<String>>, Long>(
    2215L,
    1058443396696792L,
    { lines().let { (t, ids) -> t.toInt() to ids.split(',') } }
) {
    override val partOneInputs = listOf(
        arguments(295L, 939 to listOf("7", "13", "x", "x", "59", "x", "31", "19"), "tutorial input"),
    )

    override val partTwoInputs = listOf(
        arguments(1068781L, 0 to listOf("7", "13", "x", "x", "59", "x", "31", "19"), "tutorial input 1"),
        arguments(3417L, 0 to listOf("17", "x", "13", "19"), "tutorial input 2"),
        arguments(754018L, 0 to listOf("67", "7", "59", "61"), "tutorial input 3"),
        arguments(779210L, 0 to listOf("67", "x", "7", "59", "61"), "tutorial input 4"),
        arguments(1261476L, 0 to listOf("67", "7", "x", "59", "61"), "tutorial input 5"),
        arguments(1202161486L, 0 to listOf("1789", "37", "47", "1889"), "tutorial input 6"),
        arguments(0L, 0 to emptyList<String>(), "empty input")
    )
}
