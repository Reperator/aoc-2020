package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments

class Day08Test : Test<Day08, List<String>>(1371, 2117) {
    override val partOneInputs: List<Arguments> = listOf(
        arguments(12, listOf("""""""", """"abc"""", """"aaa\"aaa"""", """"\x27""""), "tutorial input"),
    )

    override val partTwoInputs: List<Arguments> = listOf(
        arguments(19, listOf("""""""", """"abc"""", """"aaa\"aaa"""", """"\x27""""), "tutorial input"),
    )
}
