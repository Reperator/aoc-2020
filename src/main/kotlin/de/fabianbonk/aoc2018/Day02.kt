package de.fabianbonk.aoc2018

import de.fabianbonk.CustomExercise
import de.fabianbonk.toInt

object Day02 : CustomExercise<List<String>, String>("Inventory Management System") {
    override fun partOne(input: List<String>) =
        input.fold(0 to 0) { (twos, threes), line ->
            val frequencies = line.groupBy { it }.map { it.value.size }
            (twos + (2 in frequencies).toInt()) to (threes + (3 in frequencies).toInt())
        }.let { (twos, threes) ->
            "${twos * threes}"
        }

    override fun partTwo(input: List<String>): String {
        for ((i, first) in input.withIndex()) {
            for (j in i until input.size) {
                val second = input[j]
                require(first.length == second.length) {
                    "String lengths must match."
                }
                buildString {
                    for (index in first.indices) {
                        if (first[index] == second[index]) {
                            append(first[index])
                        }
                    }
                }.also {
                    if (it.length == first.length - 1) {
                        return it
                    }
                }
            }
        }

        throw IllegalArgumentException("No two strings differ by only 1 character.")
    }
}
