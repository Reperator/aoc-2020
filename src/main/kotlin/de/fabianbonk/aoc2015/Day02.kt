package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise

object Day02 : Exercise<List<String>>("I Was Told There Would Be No Math") {
    private fun parse(dimensions: String) =
        """(\d+)x(\d+)x(\d+)""".toRegex()
            .find(dimensions)
            ?.groupValues
            ?.drop(1) // the first groupValue contains the entire match
            ?.map { it.toInt() }
            ?: throw IllegalArgumentException("dimensions must match <length>x<width>x<height>")

    override fun partOne(input: List<String>) =
        input.sumBy {
            val (l, w, h) = parse(it)
            val sides = listOf(
                l * w,
                w * h,
                h * l,
            )
            (2 * sides.sum()) + sides.minOrNull()!!
        }

    override fun partTwo(input: List<String>) =
        input.sumBy {
            val dimensions = parse(it)
            (2 * dimensions.sorted().dropLast(1).sum()) + dimensions.fold(1, Int::times)
        }
}
