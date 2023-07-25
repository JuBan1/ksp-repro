package com.example.lib

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton
import org.koin.ksp.generated.module

@Singleton
class MyClass()

@Module
@ComponentScan("com.example.lib")
class LibModule

fun test() {
    val k = LibModule().module
}
