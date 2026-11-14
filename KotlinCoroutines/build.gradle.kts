plugins {
    kotlin("jvm") version "2.2.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}
