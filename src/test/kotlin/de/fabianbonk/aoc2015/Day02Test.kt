package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day02Test : Test<Day02, List<String>>(1586300, 3737498) {
    override val partOneInputs = listOf(
        arguments(58, listOf("2x3x4"), "tutorial input 1"),
        arguments(43, listOf("1x1x10"), "tutorial input 2"),
    )

    override val partTwoInputs = listOf(
        arguments(34, listOf("2x3x4"), "tutorial input 1"),
        arguments(14, listOf("1x1x10"), "tutorial input 2"),
    )
}
