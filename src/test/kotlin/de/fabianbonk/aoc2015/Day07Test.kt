package de.fabianbonk.aoc2015

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day07Test : Test<Day07, List<String>>(956, 40149) {
    override val partOneInputs = listOf(
        arguments(72, listOf("123 -> x", "456 -> y", "x AND y -> a"), "tutorial input (d)"),
        arguments(507, listOf("123 -> x", "456 -> y", "x OR y -> a"), "tutorial input (e)"),
        arguments(492, listOf("123 -> x", "x LSHIFT 2 -> a"), "tutorial input (f)"),
        arguments(114, listOf("456 -> y", "y RSHIFT 2 -> a"), "tutorial input (g)"),
        arguments(65412, listOf("123 -> x", "NOT x -> a"), "tutorial input (h)"),
        arguments(65079, listOf("456 -> y", "NOT y -> a"), "tutorial input (i)"),
        arguments(123, listOf("123 -> a"), "tutorial input (x)"),
        arguments(456, listOf("456 -> a"), "tutorial input (y)"),
        arguments(2, listOf("b -> a", "2 AND 3 -> b"), "don't require forward declaration"),
        arguments(956, reference, "reference input"),
    )
}
