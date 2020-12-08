package de.fabianbonk

abstract class CustomExercise<T, U>(
    val name: String
) {
    val year = javaClass.packageName.takeLast(4)

    val day = this::class.simpleName!!.takeLast(2)

    open fun partOne(input: T): U = TODO("Part one is not yet implemented")

    open fun partTwo(input: T): U = TODO("Part two is not yet implemented")
}

abstract class Exercise<T>(
    name: String,
) : CustomExercise<T, Int>(name) {
    override fun partOne(input: T): Int = 0

    override fun partTwo(input: T): Int = 0
}
