package com.jorgeSM.apimarvel.data

import com.jorgeSM.apimarvel.data.remote.models.CharacterItemByIdRequest
import com.jorgeSM.apimarvel.data.remote.models.CharacterResponse
import com.jorgeSM.apimarvel.data.remote.models.ListOfCharacterRequest

/*****
 * Projecto: Api marvel
 * From: com.jorgeSM.apimarvel.data.remote
 * Create by Jorge S. Medina on 8/9/22 at 15:50
 * More info: https://www.linkedin.com/in/jorge-s%C3%A1nchez-medina-bb7b7371/
 *****/
interface MarvelRepository {
    suspend fun getCharacterList(characterRequest: ListOfCharacterRequest): List<CharacterResponse?>
    suspend fun geCharacterById(request: CharacterItemByIdRequest):CharacterResponse?
}