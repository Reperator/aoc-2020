package de.fabianbonk.aoc2021

import de.fabianbonk.Exercise

enum class Direction {
    Forward, Down, Up
}

data class Command(
    val direction: Direction,
    val units: Int,
)

object Day02 : Exercise<List<String>>("Dive!") {
    private fun parse(input: List<String>) = input.map {
        val (direction, units) = it.split(' ')

        Command(
            when (direction) {
                "forward" -> Direction.Forward
                "down" -> Direction.Down
                "up" -> Direction.Up
                else -> throw IllegalArgumentException("unexpected command: $direction")
            },
            units.toInt(),
        )
    }

    override fun partOne(input: List<String>) =
        parse(input).fold(Pair(0, 0)) { (horizontal, depth), (direction, units) ->
            when (direction) {
                Direction.Forward -> Pair(horizontal + units, depth)
                Direction.Down -> Pair(horizontal, depth + units)
                Direction.Up -> Pair(horizontal, depth - units)
            }
        }.let { (horizontal, depth) ->
            horizontal * depth
        }

    override fun partTwo(input: List<String>) =
        parse(input).fold(Triple(0, 0, 0)) { (horizontal, depth, aim), (direction, units) ->
            when (direction) {
                Direction.Forward -> Triple(horizontal + units, depth + (aim * units), aim)
                Direction.Down -> Triple(horizontal, depth, aim + units)
                Direction.Up -> Triple(horizontal, depth, aim - units)
            }
        }.let { (horizontal, depth, _) ->
            horizontal * depth
        }
}
