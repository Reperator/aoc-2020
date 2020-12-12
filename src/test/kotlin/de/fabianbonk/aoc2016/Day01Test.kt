package de.fabianbonk.aoc2016

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day01Test : Test<Day01, List<String>>(161, 110, { split(", ") }) {
    override val partOneInputs = listOf(
        arguments(5, listOf("R2", "L3"), "tutorial input 1"),
        arguments(2, listOf("R2", "R2", "R2"), "tutorial input 2"),
        arguments(12, listOf("R5", "L5", "R5", "R3"), "tutorial input 3"),
    )

    override val partTwoInputs = listOf(
        arguments(4, listOf("R8", "R4", "R4", "R8"), "tutorial input 1"),
    )
}
