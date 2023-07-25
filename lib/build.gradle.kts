@file:Suppress("UnstableApiUsage", "UNUSED_VARIABLE")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.ksp)
}

version = providers.gradleProperty("versionString")

kotlin {
    jvm()

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Workaround for https://github.com/google/ksp/issues/567
                kotlin.srcDir("build/generated/ksp/jvm/jvmMain/kotlin")

                api(libs.koin)
                compileOnly(libs.koin.annotations)
            }
        }
        val jvmMain by getting
    }
}

dependencies {
    add("kspJvm", libs.koin.ksp)
}

// Taken from https://github.com/kosi-libs/MocKMP#with-ksp-and-its-incomplete-multiplatform-support
// May not be 100% correct. But seems to work for now.
tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().all {
    if (name.startsWith("compileDebugKotlin")) {
        dependsOn("kspKotlinJvm")
    }
}
