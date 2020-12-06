package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day04Test : Test<Day04, String>(117946, 3938038) {
    override val reference = "ckczppom"

    override val partOneInputs = listOf(
        arguments(609043, "abcdef", "tutorial input 1"),
        arguments(1048970, "pqrstuv", "tutorial input 2"),
    )
}
