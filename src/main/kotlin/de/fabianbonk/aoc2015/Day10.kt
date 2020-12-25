package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise
import de.fabianbonk.iterate

object Day10 : Exercise<Pair<String, Int>>("Elves Look, Elves Say") {
    override fun partOne(input: Pair<String, Int>): Int =
        input.first.iterate(times = input.second) {
            require(it.isNotEmpty()) { "input string must not be empty" }

            val (last, count, acc) =
                // need to use a StringBuilder to prevent reallocations
                it.drop(1).fold(Triple(it[0], 1, StringBuilder())) { (prev, count, acc), c ->
                    if (c == prev) {
                        Triple(c, count + 1, acc)
                    } else {
                        Triple(c, 1, acc.append(count).append(prev))
                    }
                }

            acc.append(count).append(last).toString()
        }.length

    override fun partTwo(input: Pair<String, Int>): Int = partOne(input)
}
