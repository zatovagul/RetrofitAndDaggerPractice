package com.app.fullappllication.DaggerClasses

import javax.inject.Inject
import javax.inject.Named

class Door @Inject constructor(){
    @Named("blueColor")
    @Inject
    lateinit var color:Color
}
