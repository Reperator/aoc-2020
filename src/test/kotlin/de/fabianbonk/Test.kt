@file:Suppress("unused", "UNUSED_PARAMETER", "UNCHECKED_CAST")

package de.fabianbonk

import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
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

abstract class CustomTest<E : CustomExercise<T, U>, T, U>(
    private val partOneRef: U,
    private val partTwoRef: U,
    private val processReference: String.() -> T = { lines() as T },
) {
    private val exercise = getObj(this::class.java) as E

    // not all reference inputs are stored in a file
    protected open val reference: T by lazy {
        exercise.run {
            (javaClass.getResource("/$year/input-$day.txt") ?: javaClass.getResource("/$year/input-$day.json"))
                ?.readText()
                ?.trim()
                ?.processReference()
                ?: throw IllegalStateException("$year/$day has no input: /resources/$year/input-$day.txt not found")
        }
    }

    open val referencePartTwo by lazy { reference }

    open val partOneInputs: List<Arguments> = emptyList()

    open val partOneInvalidInputs: List<Pair<T, String>> = emptyList()

    @Nested
    @DisplayName("Part One")
    inner class PartOne {
        private fun `valid inputs`() =
            partOneInputs + arguments(partOneRef, reference, "reference input")

        @ParameterizedTest(name = "{index}: {2}")
        @MethodSource
        fun `valid inputs`(expected: U, input: T, name: String) {
            assertEquals(expected, exercise.partOne(input))
        }

        @TestFactory
        fun `invalid inputs`() =
            partOneInvalidInputs.mapIndexed { index, (input, name) ->
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
        private fun `valid inputs`() =
            partTwoInputs + arguments(partTwoRef, referencePartTwo, "reference input")

        @ParameterizedTest(name = "{index}: {2}")
        @MethodSource
        fun `valid inputs`(expected: U, input: T, name: String) {
            assertEquals(expected, exercise.partTwo(input))
        }

        @TestFactory
        fun `invalid inputs`() =
            partOneInvalidInputs.mapIndexed { index, (input, name) ->
                dynamicTest("${index + 1}: $name") {
                    assertThrows<IllegalArgumentException> {
                        exercise.partTwo(input)
                    }
                }
            }
    }
}

abstract class Test<E : Exercise<T>, T>(
    partOneRef: Int = Int.MIN_VALUE,
    partTwoRef: Int = Int.MIN_VALUE,
    processReference: String.() -> T = { lines() as T },
) : CustomTest<E, T, Int>(partOneRef, partTwoRef, processReference)

class AoCDisplayNameGenerator : DisplayNameGenerator.Standard() {
    override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String =
        testMethod.name

    override fun generateDisplayNameForClass(testClass: Class<*>): String =
        try {
            getObj(testClass as Class<CustomTest<*, *, *>>).run { "$year/$day: $name" }
        } catch (e: Exception) {
            super.generateDisplayNameForClass(testClass)
        }
}

/*
 * cursed reflection magic
 *
 * takes a Class<AbstractTest<Exercise<T>, T> and returns the Exercise<T> object
 */
private fun getObj(clazz: Class<out CustomTest<*, *, *>>): CustomExercise<*, *> {
    val superclass = clazz.genericSuperclass as ParameterizedType
    val exercise = (superclass.actualTypeArguments[0] as Class<Exercise<*>>).kotlin
    return exercise.objectInstance!!
}
