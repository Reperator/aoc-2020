package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day15Test : Test<Day15, Pair<Int, List<Int>>>(276, 31916) {
    private val nums = listOf(0, 13, 16, 17, 1, 10, 6)

    override val reference = 2020 to nums

    override val partOneInputs = listOf(
        arguments(0, 10 to listOf(0, 3, 6), "tutorial input 1 (10 rounds)"),
        arguments(436, 2020 to listOf(0, 3, 6), "tutorial input 1"),
        arguments(1, 2020 to listOf(1, 3, 2), "tutorial input 2"),
        arguments(10, 2020 to listOf(2, 1, 3), "tutorial input 3"),
        arguments(27, 2020 to listOf(1, 2, 3), "tutorial input 4"),
        arguments(78, 2020 to listOf(2, 3, 1), "tutorial input 5"),
        arguments(438, 2020 to listOf(3, 2, 1), "tutorial input 6"),
        arguments(1836, 2020 to listOf(3, 1, 2), "tutorial input 7"),
    )

    override val referencePartTwo = 30000000 to nums

    override val partTwoInputs = listOf(
        arguments(175594, 30000000 to listOf(0, 3, 6), "tutorial input 1"),
        arguments(2578, 30000000 to listOf(1, 3, 2), "tutorial input 2"),
        arguments(3544142, 30000000 to listOf(2, 1, 3), "tutorial input 3"),
        arguments(261214, 30000000 to listOf(1, 2, 3), "tutorial input 4"),
        arguments(6895259, 30000000 to listOf(2, 3, 1), "tutorial input 5"),
        arguments(18, 30000000 to listOf(3, 2, 1), "tutorial input 6"),
        arguments(362, 30000000 to listOf(3, 1, 2), "tutorial input 7"),
    )
}
