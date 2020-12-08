package de.fabianbonk.aoc2020

import de.fabianbonk.Exercise

object Day07 : Exercise<List<String>>("Handy Haversacks") {
    private fun parse(input: String): Pair<String, Set<Pair<Int, String>>> {
        val (outer, rest) = input.split(" bags contain ")

        return outer to if (rest == "no other bags.") {
            emptySet()
        } else {
            rest.dropLast(1).split(", ").map {
                val (number, color) = """(\d+) ([ \p{Alpha}]+) bags?""".toRegex().find(it)?.destructured
                    ?: throw IllegalArgumentException("invalid input '$input'")
                number.toInt() to color
            }.toSet()
        }
    }

    private fun String.canContainShinyGold(
        rules: Map<String, Set<String>>,
        visited: Set<String> = emptySet()
    ): Boolean {
        if (this in visited) return false

        val inner = rules[this] ?: throw IllegalArgumentException("unknown color $this")

        return "shiny gold" in inner || inner.any { it.canContainShinyGold(rules, visited + this) }
    }

    override fun partOne(input: List<String>): Int {
        val rules = input.map(::parse).mapNotNull {
            if (it.first == "shiny gold") {
                null
            } else {
                it.first to it.second.map { (_, color) -> color }.toSet()
            }
        }.toMap()

        return rules.keys.count {
            it.canContainShinyGold(rules)
        }
    }

    private fun String.countInner(rules: Map<String, Set<Pair<Int, String>>>): Int {
        val inner = rules[this] ?: throw IllegalArgumentException("unknown color $this")

        return 1 + inner.sumBy { (number, color) ->
            println("$this contains $number of $color")
            number * color.countInner(rules)
        }
    }

    override fun partTwo(input: List<String>): Int {
        val rules = input.map(::parse).toMap()

        return "shiny gold".countInner(rules) - 1 // the outer shiny gold bag doesn't count
    }
}
