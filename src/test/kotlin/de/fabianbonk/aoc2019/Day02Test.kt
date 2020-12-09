package de.fabianbonk.aoc2019

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day02Test : Test<Day02, Triple<List<Int>, Int, Int>>(
    3562624,
    8298,
    { Triple(split(',').map { it.toInt() }, 12, 2) }
) {
    override val partOneInputs = listOf(
        arguments(2, Triple(listOf(1, 0, 0, 0, 99), 0, 0), "tutorial input 1"),
        arguments(2, Triple(listOf(2, 0, 0, 0, 99), 1, 0), "tutorial input 2 (adapted)"),
        arguments(9801, Triple(listOf(2, 0, 0, 0, 99, 0), 4, 4), "tutorial input 3 (adapted)"),
        arguments(30, Triple(listOf(1, 0, 0, 4, 99, 5, 6, 0, 99), 1, 1), "tutorial input 4"),
    )

    override val referencePartTwo = Triple(reference.first, 19690720, -1)

    override val partTwoInputs = listOf(
        arguments(1202, Triple(reference.first, 3562624, -1), "tutorial input 1")
    )
}
