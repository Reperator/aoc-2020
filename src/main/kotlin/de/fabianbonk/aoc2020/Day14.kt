package de.fabianbonk.aoc2020

import de.fabianbonk.CustomExercise
import de.fabianbonk.get
import de.fabianbonk.toLong

object Day14 : CustomExercise<List<String>, Long>("Docking Data") {
    private val memRegex = """mem\[(\d+)]""".toRegex()

    override fun partOne(input: List<String>): Long {
        var andMask = 0xfffffffffL
        var orMask = 0L
        val mem = mutableMapOf<Long, Long>()

        input.forEach { instr ->
            val (target, arg) = instr.split(" = ")

            when {
                target == "mask" -> {
                    orMask = arg.map { if (it == 'X') false else it == '1' }.toLong()
                    andMask = arg.map { if (it == 'X') true else it == '1' }.toLong()
                }
                target.matches(memRegex) -> {
                    val addr = memRegex.find(target)!!.groupValues[1].toLong()
                    mem[addr] = arg.toLong() and andMask or orMask
                }
                else -> throw IllegalArgumentException("unexpected instruction '$instr'")
            }
        }

        return mem.values.sum()
    }

    override fun partTwo(input: List<String>): Long {
        var mask = "000000000000000000000000000000000000"
        var xBits = 0
        val mem = mutableMapOf<Long, Long>()

        input.forEach { instr ->
            val (target, arg) = instr.split(" = ")

            when {
                target == "mask" -> {
                    mask = arg
                    xBits = arg.count { it == 'X' }
                }
                target.matches(memRegex) -> {
                    val raw = memRegex.find(target)!!.groupValues[1].toLong()
                    for (i in 0L until (1 shl xBits)) {
                        var j = xBits
                        val addr = mask.mapIndexed { pos, c ->
                            when (c) {
                                'X' -> i[--j]
                                '0' -> raw[35 - pos]
                                '1' -> true
                                else -> throw IllegalArgumentException("unexpected mask bit '$c'")
                            }
                        }.toLong()
                        mem[addr] = arg.toLong()
                    }
                }
                else -> throw IllegalArgumentException("unexpected instruction '$instr'")
            }
        }

        return mem.values.sum()
    }
}
