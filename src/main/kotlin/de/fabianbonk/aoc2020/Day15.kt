package de.fabianbonk.aoc2020

import de.fabianbonk.Exercise

object Day15 : Exercise<Pair<Int, List<Int>>>("Rambunctious Recitation") {
    override fun partOne(input: Pair<Int, List<Int>>): Int {
        val (rounds, startingNumbers) = input

        // IntArray is significantly faster than LinkedHashMap<Int, Int> or Array<Int?>
        val state = IntArray(rounds) // assuming all startingNumbers are less than rounds

        startingNumbers.forEachIndexed { i, n ->
            try {
                state[n] = i + 1
            } catch (_: ArrayIndexOutOfBoundsException) {
                throw IllegalArgumentException("starting value $n at index $i exceeded rounds ($rounds).")
            }
        }

        var prev = startingNumbers.last()

        for (i in startingNumbers.size until rounds) {
            val lastRound = state[prev]
            state[prev] = i
            prev = if (lastRound == 0) {
                0
            } else {
                i - lastRound
            }
        }

        return prev
    }

    override fun partTwo(input: Pair<Int, List<Int>>) = partOne(input)
}
