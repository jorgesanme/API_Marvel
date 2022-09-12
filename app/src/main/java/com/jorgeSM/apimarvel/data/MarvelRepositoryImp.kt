package com.jorgeSM.apimarvel.data

import com.jorgeSM.apimarvel.data.remote.MarvelApi
import com.jorgeSM.apimarvel.data.remote.models.CharacterItemByIdRequestDTO
import com.jorgeSM.apimarvel.data.remote.models.CharacterResponseDTO
import com.jorgeSM.apimarvel.data.remote.models.ListOfCharacterRequestDTO
import com.jorgeSM.apimarvel.utils.Const
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/*****
 * Projecto: Api marvel
 * From: com.jorgeSM.apimarvel.data
 * Create by Jorge S. Medina on 8/9/22 at 15:38
 * More info: https://www.linkedin.com/in/jorge-s%C3%A1nchez-medina-bb7b7371/
 *****/
class MarvelRepositoryImp: MarvelRepositoryDataSource {

    private var api: MarvelApi

    init {
        val client = OkHttpClient().newBuilder().build()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        api = retrofit.create(MarvelApi::class.java)
    }

    override suspend fun getCharacterList(request: ListOfCharacterRequestDTO): List<CharacterResponseDTO?> {
        val response = api.getCharacterList(
            Const.TIME_STAMP.toString(),
            Const.API_PUBLIC_KEY,
            request.hast)
        val list = mutableListOf<CharacterResponseDTO?>()
            list.add(response)
        return list

    }

    override suspend fun geCharacterById(request: CharacterItemByIdRequestDTO): CharacterResponseDTO? {
        return api.geCharacterById(
            request.id,
            Const.TIME_STAMP.toString(),
            Const.API_PUBLIC_KEY,
            request.hast
        )
    }


}