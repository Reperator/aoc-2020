package de.fabianbonk.aoc2020

import de.fabianbonk.CustomTest
import org.junit.jupiter.params.provider.Arguments.arguments

class Day16Test : CustomTest<Day16, TicketInfo, Long>(21956L, 3709435214239L, { TicketInfo.parse(this) }) {
    private val tutorial = """
        class: 1-3 or 5-7
        row: 6-11 or 33-44
        seat: 13-40 or 45-50

        your ticket:
        7,1,14

        nearby tickets:
        7,3,47
        40,4,50
        55,2,20
        38,6,12
    """.trimIndent()

    override val partOneInputs = listOf(
        arguments(71L, TicketInfo.parse(tutorial), "tutorial input"),
    )
}
