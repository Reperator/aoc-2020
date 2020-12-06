package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day03Test : Test<Day03, String>(2565, 2639, { this }) {
    override val partOneInputs = listOf(
        arguments(2, ">", "tutorial input 1"),
        arguments(4, "^>v<", "tutorial input 2"),
        arguments(2, "^v^v^v^v^v", "tutorial input 3"),
    )

    override val partTwoInputs = listOf(
        arguments(3, "^v", "tutorial input 1"),
        arguments(3, "^>v<", "tutorial input 2"),
        arguments(11, "^v^v^v^v^v", "tutorial input 3"),
    )
}
