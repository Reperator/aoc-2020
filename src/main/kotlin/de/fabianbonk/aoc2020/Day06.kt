package de.fabianbonk.aoc2020

import de.fabianbonk.Exercise

object Day06 : Exercise<List<List<String>>>("Custom Customs") {
    override fun partOne(input: List<List<String>>) =
        input.sumBy { group ->
            group.fold(emptySet<Char>()) { set, q ->
                set + q.toSet()
            }.size
        }

    override fun partTwo(input: List<List<String>>) =
        input.sumBy { group ->
            group.reduceOrNull { set, q ->
                set.filter { it in q }
            }?.length ?: 0
        }
}
