package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise

object Day10 : Exercise<Pair<String, Int>>("Elves Look, Elves Say") {
    private fun step(input: String): String {
        require(input.isNotEmpty()) { "input string must not be empty" }

        val (last, count, acc) =
            // need to use a StringBuilder to prevent reallocations
            input.drop(1).fold(Triple(input[0], 1, StringBuilder())) { (prev, count, acc), c ->
                if (c == prev) {
                    Triple(c, count + 1, acc)
                } else {
                    Triple(c, 1, acc.append(count).append(prev))
                }
            }

        return acc.append(count).append(last).toString()
    }

    override fun partOne(input: Pair<String, Int>): Int =
        (0 until input.second).fold(input.first) { acc, _ -> step(acc) }.length

    override fun partTwo(input: Pair<String, Int>): Int = partOne(input)
}
