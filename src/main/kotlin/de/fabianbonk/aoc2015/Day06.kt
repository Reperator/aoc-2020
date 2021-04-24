package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise

enum class Op {
    On, Off, Toggle;

    companion object {
        fun parse(input: String) =
            when (input) {
                "turn on" -> On
                "turn off" -> Off
                "toggle" -> Toggle
                else -> throw IllegalArgumentException("Unexpected input $input")
            }
    }
}

data class Instruction(
    val op: Op,
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
                    op = Op.parse(op),
                    xa = xa.toInt(),
                    ya = ya.toInt(),
                    xb = xb.toInt(),
                    yb = yb.toInt(),
                )
            } ?: throw IllegalArgumentException("invalid command")

    override fun partOne(input: List<String>): Int {
        val lights = Array(1000) {
            BooleanArray(1000)
        }

        input.forEach {
            val (op, xa, ya, xb, yb) = parse(it)
            for (x in xa..xb) {
                for (y in ya..yb) {
                    lights[x][y] = when (op) {
                        Op.On -> true
                        Op.Off -> false
                        Op.Toggle -> !lights[x][y]
                    }
                }
            }
        }

        return lights.sumBy { row -> row.count { it } }
    }

    override fun partTwo(input: List<String>): Int {
        val lights = Array(1000) {
            IntArray(1000)
        }

        input.forEach {
            val (op, xa, ya, xb, yb) = parse(it)
            for (x in xa..xb) {
                for (y in ya..yb) {
                    when (op) {
                        Op.On -> lights[x][y]++
                        Op.Off -> if (--lights[x][y] < 0) lights[x][y] = 0
                        Op.Toggle -> lights[x][y] += 2
                    }
                }
            }
        }

        return lights.sumBy { it.sum() }
    }
}
