package com.app.fullappllication.DaggerClasses

import com.app.fullappllication.BuildConfig
import javax.inject.Inject

class Fuel @Inject constructor(){
    val fuelType = if(BuildConfig.DEBUG){"benzine"}
    else{"diesel"}
}