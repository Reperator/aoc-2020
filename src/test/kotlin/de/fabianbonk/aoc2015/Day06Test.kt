package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day06Test : Test<Day06, List<String>>(377891, 14110788) {
    override val partOneInputs = listOf(
        arguments(
            998996,
            listOf(
                "turn on 0,0 through 999,999",
                "toggle 0,0 through 999,0",
                "turn off 499,499 through 500,500",
            ),
            "tutorial input"
        ),
    )

    override val partTwoInputs = listOf(
        arguments(
            2000001,
            listOf(
                "turn on 0,0 through 0,0",
                "toggle 0,0 through 999,999",
            ),
            "tutorial input"
        ),
    )
}
