package de.fabianbonk.aoc2016

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day03Test : Test<Day03, String>(869, 1544, { this }) {
    override val partOneInputs = listOf(
        arguments(0, "  5  10  25", "tutorial input 1"),
    )

    override val partTwoInputs = listOf(
        arguments(
            6,
            "101 301 501\n102 302 502\n103 303 503\n201 401 601\n202 402 602\n203 403 603",
            "tutorial input 1"
        ),
    )
}
