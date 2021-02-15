package com.app.fullappllication.DaggerModule

import com.app.fullappllication.DaggerClasses.Driver
import com.app.fullappllication.DaggerClasses.Ivanov
import dagger.Binds
import dagger.Module

@Module
interface DaggerModul {
    @Binds
    fun bindDriver(driver: Ivanov):Driver
}