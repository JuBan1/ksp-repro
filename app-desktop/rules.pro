 # Ktor
-keep class io.ktor.** { *; }
-keepclassmembers class io.ktor.** { volatile <fields>; }
-keep class io.ktor.client.engine.cio.** { *; }
-keep class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.atomicfu.**
-dontwarn io.netty.**
-dontwarn com.typesafe.**
-dontwarn org.slf4j.**

-dontwarn *


# Obfuscation breaks coroutines/ktor for some reason
-dontobfuscate

# https://github.com/arkivanov/Decompose/blob/master/docs/extensions/compose.md#proguard-rules-for-compose-for-desktop-jvm
-keep class com.arkivanov.decompose.extensions.compose.jetbrains.mainthread.SwingMainThreadChecker