package de.fabianbonk.aoc2020

import de.fabianbonk.Exercise

object Day05 : Exercise<List<String>>("Binary Boarding") {
    private fun seatId(pos: String) =
        pos.foldIndexed(0) { i, acc, c ->
            when (c) {
                'F', 'L' -> acc
                'B', 'R' -> acc + (1 shl (pos.length - 1 - i))
                else -> throw IllegalArgumentException("unexpected character $c")
            }
        }

    override fun partOne(input: List<String>) =
        input.maxOfOrNull(::seatId) ?: throw IllegalArgumentException("input must not be empty")

    override fun partTwo(input: List<String>) =
        input.map(::seatId).toSet().let { ids ->
            val prev = ids.find {
                it + 1 !in ids && it + 2 in ids
            } ?: throw IllegalArgumentException("no empty seat exists")
            prev + 1
        }
}
