package de.fabianbonk.aoc2016

import de.fabianbonk.Exercise

object Day03 : Exercise<String>("Squares With Three Sides") {
    override fun partOne(input: String) =
        input.lines().count { line ->
            val (a, b, c) = line.trimStart().split(""" +""".toRegex()).map { it.toInt() }
            a + b > c && a + c > b && b + c > a
        }

    override fun partTwo(input: String): Int {
        val values = input.trimStart().split("""[ \n]+""".toRegex()).map { it.toInt() }
        return (values.indices step 9).sumBy { block ->
            (block..block + 2).count { i ->
                val a = values[i]
                val b = values[i + 3]
                val c = values[i + 6]
                a + b > c && a + c > b && b + c > a
            }
        }
    }
}
