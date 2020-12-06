package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day01Test : Test<Day01, String>(280, 1797, { this }) {
    override val partOneInputs = listOf(
        arguments(0, "(())", "tutorial input 1"),
        arguments(0, "()()", "tutorial input 2"),
        arguments(3, "(((", "tutorial input 3"),
        arguments(3, "(()(()(", "tutorial input 4"),
        arguments(3, "))(((((", "tutorial input 5"),
        arguments(-1, "())", "tutorial input 6"),
        arguments(-1, "))(", "tutorial input 7"),
        arguments(-3, ")))", "tutorial input 8"),
        arguments(-3, ")())())", "tutorial input 9"),
    )
    override val partTwoInputs = listOf(
        arguments(1, ")", "tutorial input 1"),
        arguments(5, "()())", "tutorial input 2"),
    )
}
