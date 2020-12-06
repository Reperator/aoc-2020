package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise

data class Instruction(
    val op: String,
    val xa: Int,
    val ya: Int,
    val xb: Int,
    val yb: Int,
)

object Day06 : Exercise<List<String>>("Probably a Fire Hazard") {
    private fun parse(input: String) =
        """(turn on|turn off|toggle) (\d+),(\d+) through (\d+),(\d+)""".toRegex()
            .find(input)
            ?.groupValues
            ?.drop(1)
            ?.let { (op, xa, ya, xb, yb) ->
                Instruction(
                    op = op,
                    xa = xa.toInt(),
                    ya = ya.toInt(),
                    xb = xb.toInt(),
                    yb = yb.toInt(),
                )
            } ?: throw IllegalArgumentException("invalid command")

    override fun partOne(input: List<String>): Int {
        val lights = Array(1000) {
            Array(1000) { false }
        }

        input.forEach {
            val (op, xa, ya, xb, yb) = parse(it)
            for (x in xa..xb) {
                for (y in ya..yb) {
                    lights[x][y] = when (op) {
                        "turn on" -> true
                        "turn off" -> false
                        "toggle" -> !lights[x][y]
                        else -> throw IllegalStateException("unreachable")
                    }
                }
            }
        }

        return lights.sumBy { row -> row.count { it } }
    }

    override fun partTwo(input: List<String>): Int {
        val lights = Array(1000) {
            Array(1000) { 0 }
        }

        input.forEach {
            val (op, xa, ya, xb, yb) = parse(it)
            for (x in xa..xb) {
                for (y in ya..yb) {
                    when (op) {
                        "turn on" -> lights[x][y]++
                        "turn off" -> if (--lights[x][y] < 0) lights[x][y] = 0
                        "toggle" -> lights[x][y] += 2
                        else -> throw IllegalStateException("unreachable")
                    }
                }
            }
        }

        return lights.sumBy { row -> row.sum() }
    }
}
