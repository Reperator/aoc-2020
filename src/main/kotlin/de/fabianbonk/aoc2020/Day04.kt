package de.fabianbonk.aoc2020

object Day04 {
    private fun parse(input: String) =
        try {
            input.split(' ', '\n').map {
                val (key, value) = it.split(':')
                key to value
            }.toMap()
        } catch (e: IndexOutOfBoundsException) {
            throw IllegalArgumentException("cannot parse input")
        }

    fun interface Validator {
        fun validate(input: String): Boolean
    }

    private val validators = mapOf(
        "byr" to Validator {
            val (year) = """(\d{4})""".toRegex().find(it)?.destructured
                ?: return@Validator false
            year.toInt() in 1920..2002
        },
        "iyr" to Validator {
            val (year) = """(\d{4})""".toRegex().find(it)?.destructured
                ?: return@Validator false
            year.toInt() in 2010..2020
        },
        "eyr" to Validator {
            val (year) = """(\d{4})""".toRegex().find(it)?.destructured
                ?: return@Validator false
            year.toInt() in 2020..2030
        },
        "hgt" to Validator {
            val (height, unit) = """(\d+)(cm|in)""".toRegex().find(it)?.destructured
                ?: return@Validator false
            height.toInt() in if (unit == "cm") 150..193 else 59..76
        },
        "hcl" to Validator {
            """#\p{XDigit}{6}""".toRegex().matches(it)
        },
        "ecl" to Validator {
            """amb|blu|brn|gry|grn|hzl|oth""".toRegex().matches(it)
        },
        "pid" to Validator {
            """\d{9}""".toRegex().matches(it)
        },
    )

    fun partOne(input: List<String>) =
        input.count {
            val fields = parse(it).keys
            validators.all { (key, _) ->
                key in fields
            }
        }

    fun partTwo(input: List<String>) =
        input.count {
            val data = parse(it)
            validators.all { (key, validator) ->
                val value = data[key] ?: return@count false
                validator.validate(value)
            }
        }
}
