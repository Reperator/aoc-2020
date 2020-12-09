package de.fabianbonk.aoc2015

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day11Test : CustomTest<Day11, String, String>("cqjxxyzz", "cqkaabcc") {
    override val reference = "cqjxjnds"

    override val partOneInputs = listOf(
        arguments("abcdffaa", "abcdefgh", "tutorial input 1"),
        arguments("ghjaabcc", "ghijklmn", "tutorial input 2"),
    )

    // "cqjxxyzz".next() to skip "cqjxxyzz" itself
    override val referencePartTwo = "cqjxxzaa"
}
