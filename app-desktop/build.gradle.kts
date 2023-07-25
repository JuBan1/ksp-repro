plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm {
        // This seems necessary, likely because some plugin has java sources
        // https://kotlinlang.org/docs/multiplatform-dsl-reference.html#jvm-targets
        withJava()
    }
    jvmToolchain(17)

    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(projects.lib)
            }
        }
    }
}
