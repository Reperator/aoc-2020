package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise

object Day01 : Exercise<String>("Not Quite Lisp") {
    private fun step(floor: Int, direction: Char) =
        when (direction) {
            '(' -> floor + 1
            ')' -> floor - 1
            else -> throw IllegalArgumentException("unexpected character: $direction")
        }

    override fun partOne(input: String) =
        input.fold(0, ::step)

    override fun partTwo(input: String) =
        // no need to generate the entire running fold, but it's easier to read
        input.runningFold(0, ::step).indexOf(-1).also {
            require(it >= 0) { "basement never reached" }
        }
}
