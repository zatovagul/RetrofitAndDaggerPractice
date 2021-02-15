package com.app.fullappllication.DaggerClasses


import android.widget.Toast
import dagger.Lazy
import javax.inject.Inject

class Engine @Inject constructor(private var fuel: Lazy<Fuel>){
    fun start(){
        if(fuel!=null){
            println("Started with ${fuel.get().fuelType}")
        }
        else{
            println("No more fuel!")
        }
    }
}