package com.jorgeSM.apimarvel.di

import android.app.Application

class AppDIModule(private val application: Application) : DIBaseModule("AppDIModule") {

//
//    override val builder: DI.Builder.() -> Unit = {
//        bind<Application>() with singleton {application}
//    }
}