package de.fabianbonk.aoc2019

import de.fabianbonk.Exercise

data class VM(
    val mem: MutableList<Int>,
    var pc: Int = 0,
) {
    fun step() {
        when (val op = mem[pc]) {
            1 -> {
                val p1 = mem[pc + 1]
                val p2 = mem[pc + 2]
                mem[mem[pc + 3]] = mem[p1] + mem[p2]
                pc += 4
            }
            2 -> {
                val p1 = mem[pc + 1]
                val p2 = mem[pc + 2]
                mem[mem[pc + 3]] = mem[p1] * mem[p2]
                pc += 4
            }
            99 -> return
            else -> throw IllegalArgumentException("Illegal opcode $op")
        }
    }

    val isHalted: Boolean
        get() = mem[pc] == 99
}

object Day02 : Exercise<Triple<List<Int>, Int, Int>>("1202 Program Alarm") {
    override fun partOne(input: Triple<List<Int>, Int, Int>): Int {
        val (program, noun, verb) = input

        val mem = program.toMutableList()
        mem[1] = noun
        mem[2] = verb

        val vm = VM(mem)

        while (!vm.isHalted) {
            vm.step()
        }

        return mem[0]
    }

    override fun partTwo(input: Triple<List<Int>, Int, Int>): Int {
        val (program, target, _) = input

        for (noun in 0..99) {
            for (verb in 0..99) {
                if (partOne(Triple(program, noun, verb)) == target) {
                    return 100 * noun + verb
                }
            }
        }

        throw IllegalArgumentException("No combination of noun and verb yields $target")
    }
}
