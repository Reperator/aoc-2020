package de.fabianbonk

abstract class Exercise<T>(
    val name: String,
) {
    val year = javaClass.packageName.takeLast(4)

    val day = this::class.simpleName!!.takeLast(2)

    open fun partOne(input: T): Int = 0

    open fun partTwo(input: T): Int = 0
}
