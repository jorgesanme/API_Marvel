package com.jorgeSM.apimarvel.di

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