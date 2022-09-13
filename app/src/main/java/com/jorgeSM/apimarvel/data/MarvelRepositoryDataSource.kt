package com.jorgeSM.apimarvel.data

import com.jorgeSM.apimarvel.data.remote.dto.CharacterItemByIdRequestDTO
import com.jorgeSM.apimarvel.data.remote.dto.CharacterResponseDTO
import com.jorgeSM.apimarvel.data.remote.dto.ListOfCharacterRequestDTO

/*****
 * Projecto: Api marvel
 * From: com.jorgeSM.apimarvel.data.remote
 * Create by Jorge S. Medina on 8/9/22 at 15:50
 * More info: https://www.linkedin.com/in/jorge-s%C3%A1nchez-medina-bb7b7371/
 *****/
interface MarvelRepositoryDataSource {
    suspend fun getCharacterList(request: ListOfCharacterRequestDTO): List<CharacterResponseDTO?>
    suspend fun geCharacterById(request: CharacterItemByIdRequestDTO): CharacterResponseDTO?
}