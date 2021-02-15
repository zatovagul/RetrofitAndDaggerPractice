package com.app.fullappllication.DaggerClasses


import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class Car @Inject constructor(private var engine: Provider<Engine>, private var door:Door, var driver: Driver){
    var key: Key?=null
        @Inject set

    @Inject
    @Named("redColor")
    lateinit var color:Color

    fun start(){
        println("Car start")
        engine.get().start()
    }
}
class Key @Inject constructor()