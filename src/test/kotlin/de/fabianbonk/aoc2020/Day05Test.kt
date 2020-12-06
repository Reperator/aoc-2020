package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day05Test : Test<Day05, List<String>>(978, 727) {
    override val partOneInputs = listOf(
        arguments(357, listOf("FBFBBFFRLR"), "tutorial input 1"),
        arguments(567, listOf("BFFFBBFRRR"), "tutorial input 2"),
        arguments(119, listOf("FFFBBBFRRR"), "tutorial input 3"),
        arguments(820, listOf("BBFFBBFRLL"), "tutorial input 4"),
    )
}
