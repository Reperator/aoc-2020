package de.fabianbonk.aoc2015

import de.fabianbonk.Exercise

class Env(
    private val gates: Map<String, Gate>
) {
    private val store = mutableMapOf<String, Int>()

    operator fun get(wire: String) =
        store[wire]
            ?: gates[wire]?.eval(this)?.also { store[wire] = it }
            ?: throw IllegalArgumentException("undefined signal $wire")

    operator fun set(wire: String, value: Int) {
        store[wire] = value
    }
}

sealed class Gate {
    abstract fun eval(env: Env): Int

    companion object {
        private fun source(input: String) =
            try {
                Const(input.toInt())
            } catch (_: NumberFormatException) {
                Signal(input)
            }

        fun parse(input: List<String>) =
            input.map { def ->
                val shortCircuit = """(\p{Lower}+|\d+) -> (\p{Lower}+)""".toRegex()
                val shift = """(\p{Lower}+|\d+) ([RL]SHIFT) (\d+) -> (\p{Lower}+)""".toRegex()
                val binop = """(\p{Lower}+|\d+) (AND|OR) (\p{Lower}+|\d+) -> (\p{Lower}+)""".toRegex()
                val not = """NOT (\p{Lower}+|\d+) -> (\p{Lower}+)""".toRegex()
                when {
                    shortCircuit.matches(def) -> {
                        val (value, wire) = shortCircuit.find(def)!!.destructured
                        wire to source(value)
                    }
                    shift.matches(def) -> {
                        val (a, op, bits, wire) = shift.find(def)!!.destructured
                        wire to (if (op == "RSHIFT") ::Rshift else ::Lshift)(source(a), bits.toInt())
                    }
                    binop.matches(def) -> {
                        val (a, op, b, wire) = binop.find(def)!!.destructured
                        wire to (if (op == "AND") ::And else ::Or)(source(a), source(b))
                    }
                    not.matches(def) -> {
                        val (a, wire) = not.find(def)!!.destructured
                        wire to Not(source(a))
                    }
                    else -> throw IllegalStateException("unexpected gate definition: $def")
                }
            }.toMap()
    }
}

data class Const(
    val value: Int,
) : Gate() {
    override fun eval(env: Env) = value and 0xffff
}

data class Signal(
    val a: String,
) : Gate() {
    override fun eval(env: Env) = env[a]
}

data class And(
    val a: Gate,
    val b: Gate,
) : Gate() {
    override fun eval(env: Env) = a.eval(env) and b.eval(env)
}

data class Or(
    val a: Gate,
    val b: Gate,
) : Gate() {
    override fun eval(env: Env) = a.eval(env) or b.eval(env)
}

data class Rshift(
    val a: Gate,
    val bits: Int,
) : Gate() {
    override fun eval(env: Env) = (a.eval(env) ushr bits)
}

data class Lshift(
    val a: Gate,
    val bits: Int,
) : Gate() {
    override fun eval(env: Env) = (a.eval(env) shl bits) and 0xffff
}

data class Not(
    val a: Gate,
) : Gate() {
    override fun eval(env: Env) = a.eval(env).inv() and 0xffff
}

object Day07 : Exercise<List<String>>("Some Assembly Required") {
    override fun partOne(input: List<String>) = Env(Gate.parse(input))["a"]

    override fun partTwo(input: List<String>) =
        Gate.parse(input).let { gates ->
            Env(gates + ("b" to Const(Env(gates)["a"])))["a"]
        }
}
