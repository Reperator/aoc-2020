package de.fabianbonk

import org.junit.jupiter.api.DisplayNameGenerator
import java.lang.reflect.Method

@Suppress("unused")
class SuperSimpleDisplayNameGenerator : DisplayNameGenerator.Standard() {
    override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String =
        testMethod.name

    private fun String.splitCamelCase() =
        toList().joinToString(separator = "") {
            "${if (it.isUpperCase()) " " else ""}$it"
        }

    override fun generateDisplayNameForNestedClass(nestedClass: Class<*>) =
        nestedClass.simpleName.splitCamelCase()

    override fun generateDisplayNameForClass(testClass: Class<*>) =
        testClass.simpleName.splitCamelCase()
}
