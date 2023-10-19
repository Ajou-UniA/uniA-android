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

    ":feature:splash",
    ":feature:onboarding",
    ":feature:mainroot",
    ":feature:task",
    ":feature:mypage",
    ":feature:home",
    ":feature:guide",
    ":feature:community",
)