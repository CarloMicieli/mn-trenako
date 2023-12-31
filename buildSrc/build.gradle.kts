plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.23.3")
    implementation("com.github.johnrengelman:shadow:8.1.1")
    implementation("io.micronaut.gradle:micronaut-aot-plugin:4.2.1")
    implementation("io.micronaut.gradle:micronaut-gradle-plugin:4.2.1")
}
