package de.fabianbonk.aoc2015

object Day01 {
    private fun step(floor: Int, direction: Char) =
        when (direction) {
            '(' -> floor + 1
            ')' -> floor - 1
            else -> throw IllegalArgumentException("unexpected character: $direction")
        }

    fun partOne(input: String) =
        input.fold(0, ::step)

    fun partTwo(input: String) =
        // no need to generate the entire running fold, but it's easier to read
        input.runningFold(0, ::step).indexOf(-1).also {
            require(it >= 0) { "basement never reached" }
        }
}
