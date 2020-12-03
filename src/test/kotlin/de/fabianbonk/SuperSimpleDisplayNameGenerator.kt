package de.fabianbonk

import org.junit.jupiter.api.DisplayNameGenerator
import java.lang.reflect.Method

@Suppress("unused")
class SuperSimpleDisplayNameGenerator : DisplayNameGenerator.Standard() {
    override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String =
        testMethod.name
}
