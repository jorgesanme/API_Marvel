package com.jorgeSM.apimarvel.di

import com.jorgeSM.apimarvel.remote.MarvelApi
import com.jorgeSM.apimarvel.utils.Const
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkDIModule: DIBaseModule("NetworkDIModule") {

//    override val builder: DI.Builder.() -> Unit = {
//        bind<OkHttpClient>() with singleton {
//            OkHttpClient().newBuilder().build()
//        }
//
//        bind<Moshi>() with singleton {
//            Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//        }
//
//        bind<Retrofit>() with singleton {
//            Retrofit.Builder()
//                .baseUrl(Const.BASE_URL)
//                .client(instance())
//                .addConverterFactory(MoshiConverterFactory.create(instance()))
//                .build()
//        }
//        bind<MarvelApi>() with singleton {
//            instance<Retrofit>().create(MarvelApi::class.java)
//        }
//    }
}