package com.jorgeSM.apimarvel.data.remote

import com.jorgeSM.apimarvel.data.remote.models.CharacterResponse
import com.jorgeSM.apimarvel.utils.Const
import retrofit2.http.*

interface MarvelApi {

    @GET(Const.CHARACTER_LIST_PATH)
    suspend fun getCharacterList(
        @Query("ts") timeStamp: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): CharacterResponse?

    @GET(Const.CHARACTER_BY_ID)
    suspend fun geCharacterById(
        @Path("characterId")characterId: String,
        @Query("ts") timeStamp: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        ): CharacterResponse?
}