package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day08Test : Test<Day08, List<String>>(1671, 892) {
    private val tutorial = listOf(
        "nop +0",
        "acc +1",
        "jmp +4",
        "acc +3",
        "jmp -3",
        "acc -99",
        "acc +1",
        "jmp -4",
        "acc +6",
    )

    override val partOneInputs = listOf(
        arguments(5, tutorial, "tutorial input"),
    )

    override val partTwoInputs = listOf(
        arguments(8, tutorial, "tutorial input"),
    )
}
