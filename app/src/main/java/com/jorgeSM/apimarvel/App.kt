package com.jorgeSM.apimarvel

import android.app.Application
import android.content.pm.PackageManager
import android.util.Log
import com.jorgeSM.apimarvel.di.AppDIModule
import com.jorgeSM.apimarvel.di.NetworkDIModule
import com.jorgeSM.apimarvel.di.ViewModelDIModule
import com.jorgeSM.apimarvel.utils.Const
import com.jorgeSM.apimarvel.utils.Utils
import org.kodein.di.DI
import org.kodein.di.DIAware

class App() : Application()/*, DIAware*/ {

//    override val di: DI by DI.lazy {
//        import(NetworkDIModule.create())
//        import(AppDIModule(application = this@App).create())
//        import(ViewModelDIModule.create())
//    }

}