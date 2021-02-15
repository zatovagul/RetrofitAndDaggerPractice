package com.app.fullappllication

import com.app.fullappllication.DaggerClasses.*
import com.app.fullappllication.DaggerModule.DaggerModul
import com.app.fullappllication.DaggerModule.DaggerModuleObject
import dagger.Component

@Component(modules = [DaggerModuleObject::class,DaggerModul::class])
interface DaggerComponent {
    fun getCar(): Car
    fun getEngine(): Engine
    fun getFuel(): Fuel
    fun getKey(): Key

    fun inject(act:MainActivity)
}