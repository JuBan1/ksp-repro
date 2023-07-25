pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "ksp-repro"

include(":app-desktop")
include(":lib")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
