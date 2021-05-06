import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    kotlin("jvm") version "1.5.0"
}

group = "de.fabianbonk"
version = "1.0-SNAPSHOT"

tasks.withType<KotlinCompile<KotlinJvmOptions>> {
    kotlinOptions.jvmTarget = "15"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
