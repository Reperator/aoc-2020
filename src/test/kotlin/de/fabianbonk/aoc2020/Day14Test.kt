package de.fabianbonk.aoc2020

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day14Test : CustomTest<Day14, List<String>, Long>(10452688630537L, 2881082759597L) {
    override val partOneInputs = listOf(
        arguments(
            165L,
            listOf(
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0",
            ),
            "tutorial input"
        ),
    )

    override val partTwoInputs = listOf(
        arguments(
            208L,
            listOf(
                "mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1",
            ),
            "tutorial input"
        ),
    )
}
