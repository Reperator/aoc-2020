package de.fabianbonk.aoc2020

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day03Test : CustomTest<Day03, Forest, Long>(
    169L,
    7560370818L,
    { Forest(this) }
) {
    private val tutorial = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent().trim().let(::Forest)

    override val partOneInputs = listOf(
        arguments(7L, tutorial, "tutorial input"),
    )

    override val partTwoInputs = listOf(
        arguments(336L, tutorial, "tutorial input"),
    )
}
