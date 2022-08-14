package com.jorgeSM.apimarvel.di

import android.app.Application
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

class AppDIModule(private val application: Application): DIBaseModule("AppDIModule") {

//
//    override val builder: DI.Builder.() -> Unit = {
//        bind<Application>() with singleton {application}
//    }
}