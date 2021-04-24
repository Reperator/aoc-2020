package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day15Test : Test<Day15, List<Int>>(276, 31916) {
    override val reference = listOf(0, 13, 16, 17, 1, 10, 6)

    override val partOneInputs = listOf(
        arguments(436, listOf(0, 3, 6), "tutorial input 1"),
        arguments(1, listOf(1, 3, 2), "tutorial input 2"),
        arguments(10, listOf(2, 1, 3), "tutorial input 3"),
        arguments(27, listOf(1, 2, 3), "tutorial input 4"),
        arguments(78, listOf(2, 3, 1), "tutorial input 5"),
        arguments(438, listOf(3, 2, 1), "tutorial input 6"),
        arguments(1836, listOf(3, 1, 2), "tutorial input 7"),
    )

    override val partTwoInputs = listOf(
        arguments(175594, listOf(0, 3, 6), "tutorial input 1"),
        arguments(2578, listOf(1, 3, 2), "tutorial input 2"),
        arguments(3544142, listOf(2, 1, 3), "tutorial input 3"),
        arguments(261214, listOf(1, 2, 3), "tutorial input 4"),
        arguments(6895259, listOf(2, 3, 1), "tutorial input 5"),
        arguments(18, listOf(3, 2, 1), "tutorial input 6"),
        arguments(362, listOf(3, 1, 2), "tutorial input 7"),
    )
}
