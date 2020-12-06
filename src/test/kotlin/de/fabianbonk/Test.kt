@file:Suppress("unused", "UNUSED_PARAMETER", "UNCHECKED_CAST")

package de.fabianbonk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType

abstract class Test<U : Exercise<T>, T>(
    private val partOneRef: Int = Int.MIN_VALUE,
    private val partTwoRef: Int = Int.MIN_VALUE,
    private val processReference: String.() -> T = { lines() as T },
) {
    private val exercise = getObj(this::class.java) as U

    // not all reference inputs are stored in a file
    protected open val reference: T by lazy {
        exercise.run {
            javaClass
                .getResource("/$year/input-$day.txt")
                ?.readText()
                ?.trim()
                ?.processReference()
                ?: throw IllegalStateException("$year/$day has no input: /resources/$year/input-$day.txt not found")
        }
    }

    open val partOneInputs: List<Arguments> = emptyList()

    open val partOneInvalidInputs: List<Pair<T, String>> = emptyList()

    @Nested
    @DisplayName("Part One")
    inner class PartOne {
        private fun `valid inputs`() = partOneInputs + arguments(partOneRef, reference, "reference input")

        @ParameterizedTest(name = "{index}: {2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: T, name: String) {
            assertEquals(expected, exercise.partOne(input))
        }

        @TestFactory
        fun `invalid inputs`() = partOneInvalidInputs.mapIndexed { index, (input, name) ->
            dynamicTest("${index + 1}: $name") {
                assertThrows<IllegalArgumentException> {
                    exercise.partOne(input)
                }
            }
        }
    }

    open val partTwoInputs: List<Arguments> = emptyList()

    open val partTwoInvalidInputs: List<Pair<T, String>> = emptyList()

    @Nested
    @DisplayName("Part Two")
    inner class PartTwo {
        private fun `valid inputs`() = partTwoInputs + arguments(partTwoRef, reference, "reference input")

        @ParameterizedTest(name = "{index}: {2}")
        @MethodSource
        fun `valid inputs`(expected: Int, input: T, name: String) {
            assertEquals(expected, exercise.partTwo(input))
        }

        @TestFactory
        fun `invalid inputs`() = partOneInvalidInputs.mapIndexed { index, (input, name) ->
            dynamicTest("${index + 1}: $name") {
                assertThrows<IllegalArgumentException> {
                    exercise.partTwo(input)
                }
            }
        }
    }
}

class AoCDisplayNameGenerator : DisplayNameGenerator.Standard() {
    override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String =
        testMethod.name

    override fun generateDisplayNameForClass(testClass: Class<*>): String =
        try {
            getObj(testClass as Class<Test<*, *>>).run { "$year/$day: $name" }
        } catch (e: Exception) {
            super.generateDisplayNameForClass(testClass)
        }
}

/*
 * cursed reflection magic
 *
 * takes a Class<AbstractTest<Exercise<T>, T> and returns the Exercise<T> object
 */
private fun getObj(clazz: Class<out Test<*, *>>): Exercise<*> {
    val superclass = clazz.genericSuperclass as ParameterizedType
    val exercise = (superclass.actualTypeArguments[0] as Class<Exercise<*>>).kotlin
    return exercise.objectInstance!!
}
