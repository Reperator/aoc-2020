package de.fabianbonk.aoc2020

import de.fabianbonk.Test
import org.junit.jupiter.params.provider.Arguments.arguments

private fun String.parseSeats() =
    lines().map { line -> line.map { Cell.parse(it) } }

class Day11Test : Test<Day11, List<List<Cell>>>(
    2412,
    2176,
    { parseSeats() }
) {
    private val tutorial = """
        L.LL.LL.LL
        LLLLLLL.LL
        L.L.L..L..
        LLLL.LL.LL
        L.LL.LL.LL
        L.LLLLL.LL
        ..L.L.....
        LLLLLLLLLL
        L.LLLLLL.L
        L.LLLLL.LL
    """.trimIndent().parseSeats()

    override val partOneInputs = listOf(
        arguments(37, tutorial, "tutorial input"),
    )

    override val partTwoInputs = listOf(
        arguments(26, tutorial, "tutorial input"),
    )
}
