package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

class Day02Test : Test<Day02, List<String>>(418, 616) {
    private val tutorial = listOf(
        "1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc",
    )
    override val partOneInputs = listOf(
        arguments(2, tutorial, "tutorial input"),
        arguments(1, listOf("1-2 A: AA"), "uppercase"),
        arguments(1, listOf("1-1 a: abc"), "a == b"),
    )

    override val partOneInvalidInputs = listOf(
        Pair(listOf("2-1 a: "), "b < a"),
    )

    override val partTwoInputs = listOf(
        arguments(1, tutorial, "tutorial input"),
        arguments(0, listOf("1-2 a: aa"), "either a or b"),
        arguments(1, listOf("1-2 A: AB"), "uppercase"),
        arguments(1, listOf("2-1 a: ab"), "b < a"),
    )
    override val partTwoInvalidInputs = listOf(
        Pair(listOf("0-2 a: abc"), "a < 1"),
        Pair(listOf("1-0 a: abc"), "b < 1"),
        Pair(listOf("10-0 a: "), "a out of bounds"),
        Pair(listOf("1-10 a: "), "b out of bounds"),
        Pair(listOf("1-1 a: abc"), "a == b can never succeed"),
    )
}
