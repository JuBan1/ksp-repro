
plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false

    alias(libs.plugins.ksp) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}