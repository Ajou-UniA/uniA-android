package utils

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun DependencyHandler.ksp(dependency: String) {
    add("ksp", dependency)
}

internal fun DependencyHandler.kapt(dependency: String) {
    add("kapt", dependency)
}

internal fun DependencyHandler.compileOnly(dependency: String) {
    add("compileOnly", dependency)
}

internal fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

internal fun DependencyHandler.implementation(dependency: Dependency) {
    add("implementation", dependency)
}

internal fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation", dependency)
}

internal fun DependencyHandler.debugImplementation(dependency: Dependency) {
    add("debugImplementation", dependency)
}

internal fun DependencyHandler.annotationProcessor(dependency: String) {
    add("annotationProcessor", dependency)
}

internal fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

internal fun DependencyHandler.androidTestImplementation(dependency: String) {
    add("androidTestImplementation", dependency)
}