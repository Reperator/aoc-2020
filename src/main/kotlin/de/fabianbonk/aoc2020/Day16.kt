package de.fabianbonk.aoc2020

import de.fabianbonk.CustomExercise

data class TicketInfo(
    val fields: Map<String, Pair<IntRange, IntRange>>,
    val yourTicket: List<Int>,
    val nearbyTickets: List<List<Int>>,
) {
    companion object {
        fun parse(input: String): TicketInfo {
            val (rawFields, your, nearby) = input.split("\n\n")

            val fields = rawFields.lines().associate { field ->
                val (name, ranges) = field.split(": ")
                val (range1, range2) = ranges.split(" or ").map { range ->
                    val (lower, upper) = range.split("-").map { it.toInt() }
                    lower..upper
                }
                name to Pair(range1, range2)
            }

            val yourTicket = your.removePrefix("your ticket:\n").split(',').map { it.toInt() }

            val nearbyTickets = nearby.removePrefix("nearby tickets:\n").lines().map { ticket ->
                ticket.split(',').map { it.toInt() }
            }

            return TicketInfo(fields, yourTicket, nearbyTickets)
        }
    }
}

object Day16 : CustomExercise<TicketInfo, Long>("Ticket Translation") {
    override fun partOne(input: TicketInfo) =
        input.nearbyTickets.sumBy { ticket ->
            ticket.sumBy { field ->
                val valid = input.fields.all { (_, ranges) ->
                    field !in ranges.first && field !in ranges.second
                }
                if (valid) field else 0
            }
        }.toLong()

    override fun partTwo(input: TicketInfo): Long {
        val (fields, yourTicket, nearbyTickets) = input

        val validTickets = nearbyTickets.filter { ticket ->
            !ticket.any { field ->
                fields.values.all { (range1, range2) ->
                    field !in range1 && field !in range2
                }
            }
        }

        val fieldOrder = mutableMapOf<String, Int>()

        val todo = ArrayDeque(fields.keys)

        while (todo.isNotEmpty()) {
            val field = todo.removeFirst()
            val (range1, range2) = fields[field]
                ?: throw IllegalStateException("Unknown field $field.")
            val candidates = yourTicket.indices.toSet().filter { i ->
                if (i in fieldOrder.values) {
                    false
                } else {
                    validTickets.all { ticket ->
                        ticket[i] in range1 || ticket[i] in range2
                    }
                }
            }
            when (candidates.size) {
                0 -> throw IllegalArgumentException("No candidate field matches $field.")
                1 -> fieldOrder[field] = candidates[0]
                else -> todo.addLast(field)
            }
        }

        return fieldOrder.filterKeys {
            it.startsWith("departure")
        }.values.fold(1L) { acc, i ->
            acc * yourTicket[i]
        }
    }
}
