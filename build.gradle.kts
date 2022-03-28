import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    kotlin("jvm") version "1.6.10"
}

group = "de.fabianbonk"
version = "1.0-SNAPSHOT"

tasks.withType<KotlinCompile<KotlinJvmOptions>> {
    kotlinOptions.jvmTarget = "16"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
