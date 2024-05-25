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
rootProject.name = "2024AndroidTraining"

include(":app:ui")
include(":app:login")
include(":app:omikuji")
include(":app:todo")
include(":app:weather")
include(":app:sns")
include(":androidApp")
include(":desktopApp")
