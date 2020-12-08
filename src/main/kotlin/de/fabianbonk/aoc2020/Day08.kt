package de.fabianbonk.aoc2020

import de.fabianbonk.Exercise

sealed class Instr

data class Nop(val n: Int) : Instr()

data class Acc(val n: Int) : Instr()

data class Jmp(val n: Int) : Instr()

data class VM(
    val program: List<Instr>,
    val visited: MutableSet<Int> = mutableSetOf(),
    var pc: Int = 0,
    var acc: Int = 0,
) {
    /**
     * @return `true` if this [step] caused the [VM] to terminate
     */
    fun step(): Boolean {
        visited += pc
        when (val instr = program[pc]) {
            is Nop -> pc++
            is Acc -> {
                acc += instr.n
                pc++
            }
            is Jmp -> pc += instr.n
        }
        return pc == program.size
    }

    fun copy() = VM(program, visited.toMutableSet(), pc, acc)
}

object Day08 : Exercise<List<String>>("Handheld Halting") {
    private fun parse(line: String): Instr {
        val (instr, n) = line.split(' ')

        return when (instr) {
            "nop" -> ::Nop
            "acc" -> ::Acc
            "jmp" -> ::Jmp
            else -> throw IllegalStateException("Unexpected instruction '$line'")
        }(n.toInt())
    }

    override fun partOne(input: List<String>): Int {
        val vm = VM(input.map(::parse))

        while (vm.pc !in vm.visited) {
            vm.step()
        }

        return vm.acc
    }

    override fun partTwo(input: List<String>): Int {
        val program = input.mapTo(mutableListOf(), ::parse)

        val vm = VM(program)

        while (true) {
            val orig = program[vm.pc]

            program[vm.pc] = when (orig) {
                is Nop -> Jmp(orig.n)
                is Jmp -> Nop(orig.n)
                else -> {
                    vm.step()
                    continue
                }
            }

            vm.copy().let {
                while (it.pc !in it.visited) {
                    if (it.step()) return it.acc
                }
            }

            program[vm.pc] = orig

            vm.step()
        }
    }
}
