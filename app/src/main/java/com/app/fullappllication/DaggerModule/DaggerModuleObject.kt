package com.app.fullappllication.DaggerModule

import com.app.fullappllication.DaggerClasses.BoschCylinder
import com.app.fullappllication.DaggerClasses.Color
import com.app.fullappllication.DaggerClasses.Cylinder
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object DaggerModuleObject {
    @Provides
    @JvmStatic
    fun getBoschCylinder(): Cylinder=BoschCylinder()

    @Provides
    @JvmStatic
    fun getColor():Color=Color("")

    @Provides
    @Named("redColor")
    @JvmStatic
    fun getColorRed(): Color {
        return Color("red")
    }

    @Provides
    @Named("blueColor")
    @JvmStatic
    fun getColorBlue(): Color {
        return Color("blue")
    }

}