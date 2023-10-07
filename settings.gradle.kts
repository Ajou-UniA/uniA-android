pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Unia-Android"
include(
    ":app",

    ":core:data",
    ":core:domain",
    ":core:designsystem",
    ":core:network",
    ":core:loggingsystem",

    ":feature:onborading"
)